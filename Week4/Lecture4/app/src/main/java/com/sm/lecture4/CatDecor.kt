package com.sm.lecture4

class CatDecor {

    private val cat = Cat()

    fun walk(): String {
        return cat.walk()
    }

    fun decoredFun(): Int {
        return cat.id
    }
}