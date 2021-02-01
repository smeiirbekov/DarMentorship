package com.sm.hw3

data class Student(
    val id: Int,
    val name: String? = null,
    val surname: String? = null,
    val grade: Double? = null,
    val image: String? = null
) {
    override fun toString(): String {
        return "$id"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Student) return false
        return id == other.id
    }

    override fun hashCode(): Int {
        return id
    }
}
