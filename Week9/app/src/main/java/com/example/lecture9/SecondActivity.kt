package com.example.lecture9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    @Inject
    @Named("s2")
    lateinit var testInject: String // = provideStr()

    @Inject
    lateinit var testInt: MyObj

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        viewModel.increment()

        Log.d("SecondActivity", "Counter: ${viewModel.getCount()}")

        Log.d("SecondActivity", "We got injected: ${testInject}")
        Log.d("SecondActivity", "We got injected: ${testInt}")
    }

}