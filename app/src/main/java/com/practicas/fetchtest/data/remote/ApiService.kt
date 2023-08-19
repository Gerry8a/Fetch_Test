package com.practicas.fetchtest.data.remote

import com.practicas.fetchtest.utils.Dictionary.HIRING
import retrofit2.http.GET

interface ApiService {
    @GET(HIRING)
    suspend fun getListRandomItems(): Any
}