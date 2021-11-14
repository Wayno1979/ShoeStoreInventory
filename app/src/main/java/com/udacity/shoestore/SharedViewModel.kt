package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {

    private val _eventLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean>
        get() = _eventLoggedIn

    private val _eventShoeAdded = MutableLiveData<Boolean>()
    val eventShoeAdded: LiveData<Boolean>
        get() = _eventShoeAdded

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _currentShoe = MutableLiveData<Shoe>()
    val currentShoe: LiveData<Shoe>
        get() = _currentShoe

    init {
        _eventLoggedIn.value = false
        _shoeList.value = mutableListOf()
        resetCurrentShoe()
    }

    private fun resetCurrentShoe() {
        _currentShoe.value = Shoe("",0.0,"","", mutableListOf())
    }

    fun login() {
        _eventLoggedIn.value = true
    }

    fun addShoe() {
        _shoeList.value?.add(_currentShoe.value!!)
        resetCurrentShoe()
        _eventShoeAdded.value = true
    }

    fun addShoeCompleted() {
        _eventShoeAdded.value = false
    }
}