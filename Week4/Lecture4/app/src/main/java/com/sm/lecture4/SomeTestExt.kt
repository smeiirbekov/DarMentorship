package com.sm.lecture4

import android.widget.TextView

fun TextView.beginBatchEdit(){
}

fun Int.convertToDp(): Int {
    return this*32
}

sealed class SomeEnum
data class Test(val id: Int): SomeEnum()
object No: SomeEnum()
class FF: SomeEnum()