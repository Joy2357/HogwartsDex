package com.example.hogwartsdex.network

import com.example.hogwartsdex.model.Magos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface HogwartsApi {
    @GET
    fun getMagosChars(
        @Url url: String? = null
    ):Call<ArrayList<Magos>>
}