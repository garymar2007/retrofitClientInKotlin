package org.gary

import org.gary.org.gary.UserService

fun main() {
    val userService = UserService()
//    userService.successfulUsersResponse()
//    userService.headUsers()
//    userService.deleteUsers()

//    userService.dynamicGetUser("users")

//    userService.getUserById(1234)

//     userService.getUsersWithSort("name")
    val parameters = mapOf("name" to "Gary", "age" to "23")
    userService.getUsersWithDynamicQueryParams(parameters)
}