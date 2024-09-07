package org.gary.org.gary

import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

object AuthorizationInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestWithHeader = chain.request()
            .newBuilder()
            .header("Authorization", "Bearer " + UUID.randomUUID().toString())
            .build()
        return chain.proceed(requestWithHeader)
    }
}