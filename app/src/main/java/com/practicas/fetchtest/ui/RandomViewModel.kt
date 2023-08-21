package com.practicas.fetchtest.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicas.fetchtest.data.api.response.ApiResponseStatus
import com.practicas.fetchtest.data.local.entity.RandomObjectEntity
import com.practicas.fetchtest.model.RandomObject
import com.practicas.fetchtest.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _itemList = MutableLiveData<ApiResponseStatus<List<RandomObject>>>()
    val itemList: LiveData<ApiResponseStatus<List<RandomObject>>> get() = _itemList

    fun getRandomList(group: Int) = viewModelScope.launch {
        _itemList.value = ApiResponseStatus.Loading()
        repository.downloadItemList(group).let {
            when (it) {
                is ApiResponseStatus.Error -> {
                    _itemList.value = ApiResponseStatus.Error(it.message)
                }
                is ApiResponseStatus.Loading -> {}
                is ApiResponseStatus.Success -> {
                    _itemList.value = ApiResponseStatus.Success(it.data)
                    for (randomObject in it.data) {
                        insertObject(randomObject)
                    }
                }
            }
        }
    }

    fun insertObject(randomObject: RandomObject) = viewModelScope.launch {
        val randomEntity = RandomObjectEntity(
            customId = randomObject.id,
            listId = randomObject.listId,
            name = randomObject.name
        )
        repository.insertRandomObject(randomEntity)
    }
}
