package com.practicas.fetchtest.data.api.dto

import com.squareup.moshi.Json

/**
 * DTO used to fetch the data from api
 * Annotation @field:Json(name = "") used to parse name of api
 */
data class RandomObjectDTO(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "listId") val listId: Int?,
    @field:Json(name = "name") val name: String?
)