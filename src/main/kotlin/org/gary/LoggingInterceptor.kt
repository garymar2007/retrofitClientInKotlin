package org.gary.org.gary

import okhttp3.Interceptor
import okhttp3.Response

object LoggingInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        println("Request to: ${request.url()}")
        return chain.proceed(request)
            .also {
                println("Response status code: ${it.code()}")
            }
    }
}