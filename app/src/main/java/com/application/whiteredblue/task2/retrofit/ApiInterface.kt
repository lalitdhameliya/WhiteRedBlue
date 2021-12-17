package com.application.whiteredblue.task2.retrofit

import com.application.whiteredblue.task2.model.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("api/users?")
    fun getUsers(@Query("page")page:Int): Call<UserModel>
}