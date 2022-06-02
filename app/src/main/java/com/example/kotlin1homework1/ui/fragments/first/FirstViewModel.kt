package com.example.kotlin1homework1.ui.fragments.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin1homework1.model.Model

class FirstViewModel: ViewModel() {

    val liveData = MutableLiveData<ArrayList<Model>>()
    val list = ArrayList<Model>()

    fun getList() {
        list.clear()
        list.add(Model("Aman"))
        list.add(Model("Aman"))
        list.add(Model("Aman"))
        list.add(Model("Aman"))
        list.add(Model("Aman"))
        list.add(Model("Aman"))
        liveData.value = list

    }
}