package com.sm.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sm.testapp.models.MyCustomObject

class MainViewModel: ViewModel() {

    private val _myEvents = MutableLiveData<String>()
    val myEvents: LiveData<String> = _myEvents

}