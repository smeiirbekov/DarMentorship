package com.sm.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.sm.testapp.models.MyCustomObject

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

//        intent.extras?.let {
//
//            findViewById<TextView>(R.id.tv_title).text  =  it.getString("id") ?: "Po Umolchaniuyi"
//
//            Log.d("asd", "Got: ${it.getParcelable<MyCustomObject>("obj")}")
//            // asd: Got: {id=1, name=}
//
//        }

    }
}