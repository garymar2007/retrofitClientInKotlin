package org.gary

import org.gary.org.gary.UserService

fun main() {
    val userService = UserService()
//    userService.successfulUsersResponse()
//    userService.headUsers()
//    userService.deleteUsers()

    userService.dynamicGetUser("users")
}