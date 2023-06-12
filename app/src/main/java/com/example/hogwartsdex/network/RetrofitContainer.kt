package com.example.hogwartsdex.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitContainer {
    private var INSTANCE: Retrofit? = null
    fun getRetrofitContainer(): Retrofit = INSTANCE ?: synchronized(this){
        val instance = Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        INSTANCE = instance
        instance
    }
}