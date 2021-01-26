package com.sm.testapp.models

import android.os.Parcelable
import android.util.Log
import kotlinx.parcelize.Parcelize


open class MyCustomObject {

    var id: Int = 0
    var name: String? = null

    open fun run() {
        Log.d("MyCustomObject", "Running")
    }
}