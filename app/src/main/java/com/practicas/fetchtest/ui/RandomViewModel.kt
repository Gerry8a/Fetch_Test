package com.practicas.fetchtest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicas.fetchtest.data.remote.response.ApiResponseStatus
import com.practicas.fetchtest.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _itemList = MutableLiveData<ApiResponseStatus<Any>>()
    val itemList: LiveData<ApiResponseStatus<Any>> get() = _itemList

    init {
        getRandomList()
    }

    fun getRandomList() = viewModelScope.launch {
        _itemList.value = ApiResponseStatus.Loading()
        repository.downloadItemList().let {
            when(it){
                is ApiResponseStatus.Error ->{
                    _itemList.value = ApiResponseStatus.Error(it.message)
                }
                is ApiResponseStatus.Loading -> {}
                is ApiResponseStatus.Success -> _itemList.value = ApiResponseStatus.Success(it.data)
            }
        }
    }

}