package com.example.myapplication.ui.count

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountFragmentViewModel : ViewModel() {

    private val _currentCount = MutableLiveData(0)
    val currentCount: LiveData<Int>
        get() = _currentCount

    fun countMe() {
        _currentCount.value = _currentCount.value?.inc()
    }
}