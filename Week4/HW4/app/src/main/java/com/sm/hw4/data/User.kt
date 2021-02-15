package com.sm.hw4.data

data class User(
    val name: String,
    var wins: Int = 0,
    var loses: Int = 0
) {

    /* Overriding only [name] parameter to distinguish users, we don't care about wins and loses */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}
