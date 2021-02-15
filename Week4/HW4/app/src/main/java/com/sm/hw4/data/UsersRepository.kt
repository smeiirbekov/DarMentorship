package com.sm.hw4.data

object UsersRepository {

    val users = mutableListOf<User>()

    fun addWinner(name: String) {
        val user = User(name)
        val userIndex = users.indexOf(user)
        if (userIndex >= 0) {
            users[userIndex].wins++
        } else {
            user.wins++
            users.add(user)
        }
    }

    fun addLoser(name: String) {
        val user = User(name)
        val userIndex = users.indexOf(user)
        if (userIndex >= 0) {
            users[userIndex].loses++
        } else {
            user.loses++
            users.add(user)
        }
    }

}