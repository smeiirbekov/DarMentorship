package com.sm.testapp.rv_example

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.sm.testapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

class SecondActivity: AppCompatActivity() {

    private lateinit var rv: RecyclerView
    private lateinit var adapter: MovieAdapter
    private lateinit var srl: SwipeRefreshLayout
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d("Activity", "Here")
        rv = findViewById(R.id.rv)
        adapter = MovieAdapter()

        rv.adapter = adapter

        srl = findViewById(R.id.srl)

        loadData()
        srl.setOnRefreshListener {
            appendData()
        }
    }

    private fun loadData(){
        rv.postDelayed({
            val listOfMovies = arrayListOf<Movie>()
            for (i in index..(index+10)) {
                listOfMovies.add(Movie(i, "Movie #$i"))
            }
            findViewById<FrameLayout>(R.id.content_loading).visibility = View.GONE
            adapter.submitList(listOfMovies)
            index += 10
        }, 2000)
    }

    private fun appendData(){
        rv.postDelayed({
            val listOfMovies = arrayListOf<Movie>()
            for (i in index..(index+10)) {
                listOfMovies.add(Movie(i, "Movie #$i"))
            }
            adapter.appendList(listOfMovies)
            srl.isRefreshing = false
            index += 10
        }, 2000)
    }

}