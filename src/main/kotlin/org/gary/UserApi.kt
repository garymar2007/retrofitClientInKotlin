package org.gary.org.gary

import org.gary.User
import retrofit2.Call
import retrofit2.http.*

interface UserApi {
    @GET("users")   // auto-converted to http://localhost:8090/v1/users
    //@GET("http://localhost:8080/v1/users")   // overridde the baseUrl
    //NB: @GET("/users") will be http://localhost:8090/users since "/" (root) is used
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

    @GET
    fun dynamicGetUsers(@Url url: String): Call<List<User>>

    @GET("users/{id}")
    fun getUserById(@Path("id") id: Long): Call<User>

    /**
     * This endpoint is http://localhost:8090/v1/users?sort_by=name
     * However, it requires http://localhost:8090/v1/users to be available
     */
    @GET("users")
    fun getUsersWithSort(
        @Query("sort_by") sortBy: String = "name"
    ): Call<List<User>>

    @GET("users")
    @Headers(value = [
        "User-agent: retrofit-client-application",
        "another-header: another-value",
    ])
    fun getUsersWithDynamicQueryParams(
        @QueryMap parameters: Map<String, String>
    ): Call<List<User>>

    @GET("users")
    fun getUsersWithAuth(@Header("Authorization") auth: String): Call<List<User>>

    @GET("users")
    fun getUsersWithHeaderMap(@HeaderMap auth: Map<String, String>): Call<List<User>>
}