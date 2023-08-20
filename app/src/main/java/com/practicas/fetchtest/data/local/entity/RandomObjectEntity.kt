package com.practicas.fetchtest.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.practicas.fetchtest.utils.Dictionary.RANDOM_OBJECT_TABLE

@Entity(tableName = RANDOM_OBJECT_TABLE)
data class RandomObjectEntity(
    @PrimaryKey (autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "customId") val customId: Int?,
    val listId: Int?,
    val name: String?
)