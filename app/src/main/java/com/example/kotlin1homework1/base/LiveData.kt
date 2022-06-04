package com.example.kotlin1homework1.base

class LiveData<T>(dataToBeConsumed: T? = null) {

    private var _data: T? = dataToBeConsumed

    val isConsumed
        get() = _data == null

    fun consumeData(): T {
        val curData = _data!!
        _data = null
        return curData
    }

    fun consumeDataSafely(): T? {
        val curData = _data
        _data = null
        return curData
    }
}