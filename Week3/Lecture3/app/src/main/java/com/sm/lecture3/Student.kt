package com.sm.lecture3

data class Student(
    val id: Int,
    val name: String? = null,
    val surname: String? = null,
    val image: String? = null /* BASE64 format file -> generally has more than 1 mb size */
)
