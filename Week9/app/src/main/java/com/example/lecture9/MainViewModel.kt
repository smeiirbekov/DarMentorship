package com.example.lecture9

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: TestRepository
): ViewModel() {


    fun getCount() = repo.counter

    fun increment() {
        repo.counter = repo.counter + 1
    }

    init {
        Log.d("ASD", "Got: ${repo.getObj()}")
    }
}