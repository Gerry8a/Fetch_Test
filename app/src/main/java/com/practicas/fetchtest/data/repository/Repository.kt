package com.practicas.fetchtest.data.repository

import com.practicas.fetchtest.data.api.ApiService
import com.practicas.fetchtest.data.api.makeNetworkCall
import com.practicas.fetchtest.data.api.response.ApiResponseStatus
import com.practicas.fetchtest.data.api.response.RandomObject
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun downloadItemList(): ApiResponseStatus<List<RandomObject>> = makeNetworkCall {
        apiService.getListRandomItems()
    }
}