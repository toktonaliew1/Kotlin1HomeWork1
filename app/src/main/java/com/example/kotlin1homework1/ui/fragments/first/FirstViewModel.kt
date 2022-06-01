package com.example.kotlin1homework1.ui.fragments.first

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin1homework1.model.Model

class FirstViewModel: ViewModel() {

    val liveData = MutableLiveData<ArrayList<Model>>()
    val list = ArrayList<Model>()

    fun getList() {
        list.add(Model("Aman"))
        list.add(Model("Arsen"))
        list.add(Model("Arzyke"))
        list.add(Model("Ilgiz"))
        list.add(Model("Alexandr"))
        list.add(Model("Suhrab"))
        liveData.value = list
    }
}