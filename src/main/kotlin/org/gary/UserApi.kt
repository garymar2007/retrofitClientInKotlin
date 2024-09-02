package org.gary.org.gary

import org.gary.User
import retrofit2.Call
import retrofit2.http.*

interface UserApi {
    @GET("users")
    //@HTTP(method = "GET", path = "users")
    fun getUsers(): Call<List<User>>

    @HEAD("users")
    fun headUsers(): Call<Void>

    @POST("users")
    fun createUser(user: User): Call<User>

    fun updateUser(user: User): Call<User>

    @HTTP(method = "DELETE", path = "users", hasBody = true)
    //@DELETE("users") // This is not allowed if we use @Body as non-http method cannot use body
    fun deleteUser(@Body body: User): Call<List<User>>
}