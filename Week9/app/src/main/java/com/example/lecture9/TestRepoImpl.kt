package com.example.lecture9

import android.content.Context
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject


class TestRepoImpl constructor(context: Context, val ob: MyObj): TestRepository {

    override var counter = 0


    override fun getObj(): MyObj {
        return ob
    }


}