package com.example.myapplication.ui.random_number

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomNumberFragmentViewModel : ViewModel() {
    private val _randomNumber = MutableLiveData(0)
    val randomNumber: LiveData<Int>
        get() = _randomNumber


    fun random(count: Int) {
        _randomNumber.value = if (count > 0) java.util.Random().nextInt(count + 1) else 0
    }
}