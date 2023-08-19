package com.practicas.fetchtest.data.api.dto

import com.squareup.moshi.Json

data class RandomObjectDTO(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "listId") val listId: Int?,
    @field:Json(name = "name") val name: String?
)