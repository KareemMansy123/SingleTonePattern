package com.adm.freejna.versionfreejna.presentation.pojo.network

import info.info.singletonepattern.network.interceptorLOG
import info.info.singletonepattern.network.interpetor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object OkHttpClient {

    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interpetor)
            .addInterceptor(interceptorLOG)
            .build()
    }

}