package com.application.whiteredblue.task2.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val MainServer = "https://reqqres.in/"

    private val retrofitClient: Retrofit.Builder by lazy {
        val okHttpClient = OkHttpClient.Builder()

        Retrofit.Builder()
            .baseUrl(MainServer)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: ApiInterface by lazy {
        retrofitClient.build().create(ApiInterface::class.java)
    }

}