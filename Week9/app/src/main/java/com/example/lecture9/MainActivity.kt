package com.example.lecture9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named
import androidx.activity.viewModels

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    @Inject
    @Named("s1")
    lateinit var testInject: String // = provideStr()


    override fun onResume() {
        super.onResume()

        viewModel.getCount()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "We got injected: ${testInject}")

        findViewById<Button>(R.id.btn).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

}