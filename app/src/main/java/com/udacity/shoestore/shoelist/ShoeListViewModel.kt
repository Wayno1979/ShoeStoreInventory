package com.udacity.shoestore.shoelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private var _shoeList = MutableLiveData<MutableList<Shoe>>(mutableListOf())
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

}