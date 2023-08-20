package com.practicas.fetchtest.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.practicas.fetchtest.data.local.entity.RandomObjectEntity
import com.practicas.fetchtest.utils.Dictionary.RANDOM_OBJECT_TABLE

@Dao
interface RandomObjectDao {
 /*   @Query("SELECT * FROM random_table")
    suspend fun getAllData(): List<RandomObjectEntity>*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(randomObjectEntity: RandomObjectEntity)
}