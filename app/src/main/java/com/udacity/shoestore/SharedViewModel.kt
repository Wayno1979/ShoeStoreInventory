package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class SharedViewModel : ViewModel() {

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean>
        get() = _isLoggedIn

    private val _newShoeAdded = MutableLiveData<Boolean>()
    val newShoeAdded: LiveData<Boolean>
        get() = _newShoeAdded

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _currentShoe = MutableLiveData<Shoe>()
    val currentShoe: LiveData<Shoe>
        get() = _currentShoe

    init {
        _isLoggedIn.value = false
        _newShoeAdded.value = false
        _shoeList.value = mutableListOf()
        resetCurrentShoe()
    }

    private fun resetCurrentShoe() {
        _currentShoe.value = Shoe("",0.0,"","", mutableListOf())
    }


}