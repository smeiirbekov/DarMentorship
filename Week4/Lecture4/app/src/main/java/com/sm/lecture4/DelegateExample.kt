package com.sm.lecture4

import android.app.Activity
import kotlin.reflect.KProperty

class DelegateExample() {

    private var data = ""

    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${prop.name}' to me! Your result is: $data"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value has been assigned to ${prop.name} in $thisRef")
        data = value
    }

}