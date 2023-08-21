package com.practicas.fetchtest.data.api

import com.practicas.fetchtest.R
import com.practicas.fetchtest.data.api.response.ApiResponseStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

/**
 * Catch any kind of exception
 */
suspend fun <T> makeNetworkCall(
    call: suspend () -> T
): ApiResponseStatus<T> = withContext(Dispatchers.IO){
    try {
        ApiResponseStatus.Success(call())
    } catch (e: UnknownHostException){
        //No internet connection
        ApiResponseStatus.Error(e.message.toString())
    } catch (e: Exception){
        //Unknown error
        ApiResponseStatus.Error(e.message.toString())
    }
}

