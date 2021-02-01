package com.sm.lecture4

import android.util.Log

class GenClass<T: Animal, J> {

    fun doTest(item: T) {
        Log.d("Main", "Got: ${item}")
    }

}