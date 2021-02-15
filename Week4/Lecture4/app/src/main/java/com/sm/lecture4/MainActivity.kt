package com.sm.lecture4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val viewModel:MainViewModel by viewModels()

    private var someString: String by DelegateExample()


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
        someString = "Updated"
        Log.d("Main", "DelegateTest2: ${someString}")



        val n = 5
        val m = 5
        val x = n.xor(m)

        val arrInv = Array<Array<Animal>>(2) { Array(2) { Cat() } }


        val arrCat = Array<Cat>(2) { Cat() }
        val arrAnimal = Array<Animal>(2) { Cat() }

        //arrInv[0] = arrCat
        arrInv[1] = arrAnimal



        val listInv = ArrayList<List<Animal>>()

        val listCat = ArrayList<Cat>()
        val listAnimal = ArrayList<Animal>()

        listInv.add(listCat)
        listInv.add(listAnimal)


        // Food -> FastFood -> Burger

        // In -> Consumer
        // Out -> Producer

        var i: Int? = 5
        i = null


        val l = arrayListOf<ComplexData>()
        l.add(ComplexData(1, null)) // size = 1, maxIndex = 0

        // list of Animals -> 1000
        // cat - change in variable
        // notifyDataSetChanged()
        // notifyItemChanged()

        // Added // Changed some items // Swapped some items


        // list > NewList
        //
        // DiffUtils
        //

        doServerRequest(object : GeneralCallback {
            override fun onSuccess() {

            }

            override fun onError() {
                TODO("Not yet implemented")
            }
        })


        // LiveData<Student> items
        //
        /*
        items.observe(viewLifeCycleOwner) { it -> // List<Student>
            adapter.submitList(it)
        }
        */
        // Fragment -> View -> LifeCycle
        // Fragment -> LifeCycle
        // Activity -> LifeCycle
        // onResume -> Peredast dannye

        // Scope
        // ViewModelScope
        // FragmentScope
        // flow.asLiveData()

    }

    lateinit var s: SomeEnum

    interface GeneralCallback{

        fun onSuccess()

        fun onError()

    }

    fun doServerRequest(callback: GeneralCallback) {
        // Thread do in bg
        // When things ready, use callback
        // callback.onSuccess()
    }

}

