package org.gary

import org.gary.org.gary.UserService

/**
 * This app is only to demonstrate how to use Retrofit in Kotlin:
 * 1. using a fake API server to simulate the responses;(Mockoon API Server tool)
 * 2. invoke some basic HTTP methods: GET, POST, PUT, DELETE to the endpoints in that fake API server;
 *
 */
fun main() {
    val userService = UserService()
//    userService.successfulUsersResponse()
//    userService.headUsers()
//    userService.deleteUsers()

//    userService.dynamicGetUser("users")

//    userService.getUserById(1234)

//     userService.getUsersWithSort("name")
//    val parameters = mapOf("name" to "Gary", "age" to "23")
//    userService.getUsersWithDynamicQueryParams(parameters)

//    userService.getUsersWithAuth("Bearer some-token")
//    userService.getUsersWithHeaderMap(mapOf("Authorization" to "Bearer another-token"))
//    val user: User = User(111, "Carol", 21)
//    userService.createUser(user)

    userService.getUsers()


    //https://www.youtube.com/watch?v=lT3-NBWV9HU 37:00
}