package com.sm.lecture4

import android.app.Activity
import android.widget.TextView

object TextViewUtils {

    fun getViewModel(activity: Activity): String {
        return activity::class.java.simpleName
    }

}