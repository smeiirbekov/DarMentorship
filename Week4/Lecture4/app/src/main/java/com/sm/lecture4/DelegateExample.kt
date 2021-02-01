package com.sm.lecture4

import android.app.Activity
import kotlin.reflect.KProperty

class DelegateExample(private var data: String = "") {

    operator fun getValue(activity: Activity, property: KProperty<*>): String {
        if (data.isEmpty()) {
            if (activity is MainActivity) {
                data = "This is from MainActivity"
            } else {
                data = "This is from Unknown Activity"
            }
        }

        return data
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        data = value
    }


}