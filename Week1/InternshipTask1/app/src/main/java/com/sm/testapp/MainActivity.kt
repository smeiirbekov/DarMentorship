package com.sm.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sm.testapp.models.ChildObject
import com.sm.testapp.models.MyCustomObject
import java.util.concurrent.Executors


const val tvTitleKey = "id"
const val objKey = "obj"

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testDoc(1)
        val etTest = findViewById<EditText>(R.id.et_test)

//        val myObj = MyCustomObject(1, "testObje")

        findViewById<Button>(R.id.button).setOnClickListener {
//            val bundle = Bundle()
//            bundle.putString(tvTitleKey, etTest.text.toString())
            val intent = Intent(this, ThirdActivity::class.java).apply {
//                putExtra("id",etTest.text.toString())
            }
            intent.putExtras(bundleOf(
//                    Pair(tvTitleKey, etTest.text.toString()),
//                    Pair(objKey, myObj)
            ))
            startActivity(intent)
        }

        

    }



    /**
     * This is test method that does nothing
     * @author Serik
     * @param id id that we need to pass
     *
     * */
    private fun testDoc(id: Int){
    }


}