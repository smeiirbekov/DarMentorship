package com.sm.lecture5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sm.lecture5.data.DataRepository
import com.sm.lecture5.data.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val repository = DataRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // val adapter
        CoroutineScope(Dispatchers.IO).launch {
            val res = repository.getTasks()
            if (res is State.Success) {
                // adapter.submitList(res.result)
            }
        }

        // tasks.observe(this) { list ->
        // adapter.submitlist(list)
    // }
    }

//    private fnu test(callback: Callback<Task>) {
    // callback.success(Task)
    // callback.error()
//    }

}