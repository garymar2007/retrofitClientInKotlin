package org.gary.org.gary

import com.fasterxml.jackson.databind.ObjectMapper
import org.gary.User
import retrofit2.Response

class UserService {
    private val retrofitClient = RetrofitClient.getClient()
    private val userApi = retrofitClient.create(UserApi::class.java)
    private val objectMapper = ObjectMapper()

    fun successfulUsersResponse() {
        processUserResponse(userApi.getUsers()
            .execute())
    }

    fun headUsers() {
        val userService = userApi.headUsers()
            .execute()
    }

    fun deleteUsers() {
        userApi.deleteUser(User(123, "Gary", 23))
    }

    fun dynamicGetUser(url: String) {
        processUserResponse(userApi.dynamicGetUsers(url).execute())
    }

    private fun processUserResponse(usersResponse: Response<List<User>>) {
        val successful = usersResponse.isSuccessful
        val httpStatusCode = usersResponse.code()
        val httpStatusMessage = usersResponse.message()
        val body = usersResponse.body()

        println("Was the request successful: $successful")
        println("HTTP status code: $httpStatusCode")
        println("HTTP status message: $httpStatusMessage")
        println("Response body: $body")

        if (successful) {
            body?.forEach {
                println("User: $it")
            }

            val headers = usersResponse.headers()
            val customheaderValue = headers["custom-header"]
            println("Custom header value: $customheaderValue")
        } else {
            val errorBody = usersResponse.errorBody()
            val errorResponse = errorBody?.let {
                objectMapper.readValue(it.string(), ErrorResponse::class.java)
            }
            println("Error response: $errorResponse")
        }
    }
}