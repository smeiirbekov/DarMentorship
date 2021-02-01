package com.sm.lecture4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()

    private val someString: String by DelegateExample()

    private val someString2: String by DelegateExample("Constructred")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cat = Cat()
        val dog = Dog(3)
        val enhancedDog = EnhancedDog()
        val kitten = Kitten()

        val list = mutableListOf<Animal>()
        list.add(cat)
        list.add(dog)
        list.add(enhancedDog)
        list.add(kitten)

        list.forEach {
            Log.d("Main", "Walking: ${it.walk()}")
        }

        // Any as Animal
        //

        val d = DataClass(1, "Title")

        val (a, b) = d

        Log.d("Main", "Got: ${a}")

        Log.d("Main", "Got: ${b}")


        // Java s1 == s2 // Reference check
        // Kotlin s1 == s2 // Equals method check
        // Kotlin s1 === s2 // reference
        var s1 = "Te"
        var s2 = "Te"
        val arr = CharArray(4)
        arr[0] = 'T'
        arr[1] = 'e'
        val ss = String(arr).intern()

        // Kotlin -> Android, iOS, Java (JVM), JavaScript
        // Java

        // Strings are immutable == final
        // Memory -> Heap -> String Pool ()

        Log.d("Main", "isEqual: ${s1 == s2}") // True
        Log.d("Main", "isEqual: ${s1 === s2}") // True
        Log.d("Main", "isEqual: ${s1 === ss}") // True

        Log.d("Main", "DelegateTest: ${someString}")
        Log.d("Main", "DelegateTest2: ${someString2}")
    }

    lateinit var s: SomeEnum
}

