package info.info.singletonepattern.network

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

val interceptorLOG: HttpLoggingInterceptor by lazy {

    HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
        Log.d("BoDY::", this.level.toString())

    }
}