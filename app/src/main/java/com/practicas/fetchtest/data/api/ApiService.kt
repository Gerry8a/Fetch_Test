package com.practicas.fetchtest.data.api

import com.practicas.fetchtest.data.api.response.RandomObject
import com.practicas.fetchtest.utils.Dictionary.HIRING
import retrofit2.http.GET

interface ApiService {
    @GET(HIRING)
    suspend fun getListRandomItems(): List<RandomObject>
}