package com.example.lecture9

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject


interface TestRepository {

    var counter: Int

    fun getObj(): MyObj
}