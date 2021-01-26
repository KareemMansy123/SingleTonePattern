package com.adm.freejna.versionfreejna.presentation.pojo.network

import com.adm.freejna.versionfreejna.presentation.pojo.network.OkHttpClient.okHttpClient
import com.google.gson.GsonBuilder
import info.info.singletonepattern.networkInterFace.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val retrofitBuilder: Retrofit.Builder by lazy {
        val gson = GsonBuilder().serializeNulls().create()
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))

    }


    val apiService: ApiService by lazy {

        retrofitBuilder.build()
                .create(ApiService::class.java)
    }

}