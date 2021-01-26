package info.info.singletonepattern.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

 val interpetor: Interceptor by lazy {

    object : Interceptor {

        override fun intercept(chain: Interceptor.Chain): Response {
            var request: Request? = null
            try {
                //..
                val url = chain.request().url

                val httpUrl = url.newBuilder()
                    //.addQueryParameter("appid", RetrofitBuilder.API_KEY)
                    .build()

                val requestBuilder = chain.request().newBuilder().url(httpUrl)
                requestBuilder.addHeader("Content-Type", "application/json")
                request = requestBuilder.build()
                return chain.proceed(request)

            } catch (ex: Exception) {
                Log.d("okhttp>:", "May Time Out:" + ex.message)
                //Toast.makeText(con,"",Toast.LENGTH_LONG).show()
            }
            return chain.proceed(request!!)
        }

    }

}//....
