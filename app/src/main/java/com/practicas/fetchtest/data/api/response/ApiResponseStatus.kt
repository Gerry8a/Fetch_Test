package com.practicas.fetchtest.data.api.response

/**
 * <T> is used to generalize the data type to get different kind
 * I use this response in case there is more than one service
 */
sealed class ApiResponseStatus<T> {
    class Success<T>(val data: T) : ApiResponseStatus<T>()
    class Loading<T>() : ApiResponseStatus<T>()
    class Error<T>(val message: String) : ApiResponseStatus<T>()
}