package com.application.whiteredblue.task2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.application.whiteredblue.task2.model.UserModel
import com.application.whiteredblue.task2.repository.UserRepository

class UserViewModel : ViewModel() {

    var userLiveData: MutableLiveData<UserModel>? = null

    fun getUser(): LiveData<UserModel>? {
        userLiveData = UserRepository.getUserApiCall()
        return userLiveData
    }
}