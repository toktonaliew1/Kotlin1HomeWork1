package com.example.kotlin1homework1.ui.fragments.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin1homework1.model.Model

class FirstViewModel: ViewModel() {

    val liveData = MutableLiveData<ArrayList<Model>>()
    val list = ArrayList<Model>()

    init {
        getList()
    }

    fun getList() {
        list.add(Model("Aslan"))
        list.add(Model("Arsen"))
        list.add(Model("Arzymat"))
        list.add(Model("Alexandr"))
        list.add(Model("Ilya"))
        list.add(Model("Suhrab"))
        liveData.value = list
    }
}