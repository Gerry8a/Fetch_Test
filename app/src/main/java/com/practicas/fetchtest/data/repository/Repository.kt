package com.practicas.fetchtest.data.repository

import com.practicas.fetchtest.data.api.ApiService
import com.practicas.fetchtest.data.api.dto.RandomObjectDTOMapper
import com.practicas.fetchtest.data.api.makeNetworkCall
import com.practicas.fetchtest.data.api.response.ApiResponseStatus
import com.practicas.fetchtest.data.local.dao.RandomObjectDao
import com.practicas.fetchtest.data.local.entity.RandomObjectEntity
import com.practicas.fetchtest.model.RandomObject
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService,
    private val randomDao: RandomObjectDao
) {

    suspend fun downloadItemList(): ApiResponseStatus<List<RandomObject>> = makeNetworkCall {
        val randomListApiResponse = apiService.getListRandomItems()
        val randomDTOList = randomListApiResponse
        val mapper = RandomObjectDTOMapper()
        mapper.sortedList(randomDTOList)
    }

    suspend fun insertRandomObject(entity: RandomObjectEntity) = randomDao.insertData(entity)
}