package org.gary.org.gary

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://localhost:8090/v1/"
    private val intercept = OkHttpClient.Builder()
        .addInterceptor(LoggingInterceptor)
        .build()

    fun getClient(): Retrofit =
        Retrofit.Builder()
            .client(intercept)
            .baseUrl(BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build()


}