package com.sm.testapp.models

import android.util.Log

class ChildObject(
        var content: String?
): MyCustomObject() {

    override fun run() {

        Log.d("ChildObject", "Running")
    }
}
