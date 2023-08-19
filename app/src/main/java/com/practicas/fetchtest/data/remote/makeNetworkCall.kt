package com.practicas.fetchtest.data.remote

import com.practicas.fetchtest.R
import com.practicas.fetchtest.data.remote.response.ApiResponseStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

suspend fun <T> makeNetworkCall(
    call: suspend () -> T
): ApiResponseStatus<T> = withContext(Dispatchers.IO){
    try {
        ApiResponseStatus.Success(call())
    } catch (e: UnknownHostException){
        //No internet connection
        ApiResponseStatus.Error(R.string.no_internet_connection)
    } catch (e: Exception){
        //Unknown error
        ApiResponseStatus.Error(R.string.unknown_error)
    }
}

