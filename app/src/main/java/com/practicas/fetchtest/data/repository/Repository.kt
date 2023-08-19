package com.practicas.fetchtest.data.repository

import com.practicas.fetchtest.data.remote.ApiService
import com.practicas.fetchtest.data.remote.makeNetworkCall
import com.practicas.fetchtest.data.remote.response.ApiResponseStatus
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun downloadItemList(): ApiResponseStatus<Any> = makeNetworkCall {
        apiService.getListRandomItems()
    }
}