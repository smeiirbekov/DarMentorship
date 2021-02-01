package com.sm.lecture4

import android.widget.TextView

class Kitten: Cat() {

    override fun walk(): String {
        val tv: TextView? = null
        return super.walk() + ", it's kitten"
    }

}