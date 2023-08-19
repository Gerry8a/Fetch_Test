package com.practicas.fetchtest.data.api.response

import com.squareup.moshi.Json

data class RandomObject(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "listId") val listId: Int,
    @field:Json(name = "name") val name: String
)