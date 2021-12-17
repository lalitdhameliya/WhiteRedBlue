package com.application.whiteredblue.task2.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.application.whiteredblue.task2.model.UserModel
import com.application.whiteredblue.task2.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object UserRepository {
    val userLiveData = MutableLiveData<UserModel>()

    fun getUserApiCall(): MutableLiveData<UserModel> {
        val call = RetrofitClient.apiInterface.getUsers(1)

        call.enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                userLiveData.value = response.body()
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                Log.e("USER_REPO", "onFailure: ${t.localizedMessage}")
            }
        })
        return userLiveData
    }
}