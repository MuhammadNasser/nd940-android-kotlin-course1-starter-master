package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class MainActivityViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        Timber.i("MainActivityViewModel init() called")
        fillShoeList()
    }

    override fun onCleared() {
        Timber.i("MainActivityViewModel onCleared() called")
        super.onCleared()
    }

    fun addShoe(name: String, size: Double, company: String, description: String) {
        _shoeList.value = _shoeList.value?.plus(Shoe(name, size, company, description))
        Timber.i("MainActivityViewModel shoe $name added to list")
    }

    private fun fillShoeList() {
        _shoeList.value = listOf()
        addShoe("Sneaker", 42.0, "adidas", "Sneaker shoe from adidas size 42")
        addShoe("Running", 43.0, "adidas", "Running shoe from adidas size 43")
    }
}