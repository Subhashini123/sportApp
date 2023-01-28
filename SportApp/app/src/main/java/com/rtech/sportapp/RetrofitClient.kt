package com.rtech.sportapp

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// object keyword -> singleton class
object RetrofitClient {
    val sportService: SportApiService
        get(){
            return Retrofit.Builder()
                .baseUrl("https://demo.sportz.io")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SportApiService::class.java)
        }

    val okHttpClient: OkHttpClient
        get(){
            return OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .build()
        }
}