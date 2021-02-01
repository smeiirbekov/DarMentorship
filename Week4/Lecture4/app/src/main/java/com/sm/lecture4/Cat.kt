package com.sm.lecture4

import android.widget.TextView
import androidx.annotation.CallSuper

open class Cat(): Animal {

    override val id: Int = 1


    @CallSuper
    override fun walk() = "Cat walks"

    fun walk(withSomething: String) = "Cat walks with $withSomething"


    companion object {
        var f = 1

        fun doSomething(){

        }
    }
}