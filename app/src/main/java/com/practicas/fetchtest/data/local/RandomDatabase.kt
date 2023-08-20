package com.practicas.fetchtest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.practicas.fetchtest.data.local.dao.RandomObjectDao
import com.practicas.fetchtest.data.local.entity.RandomObjectEntity
import com.practicas.fetchtest.utils.Dictionary.DATABASE_VERSION

@Database(
    entities = [RandomObjectEntity::class], version = DATABASE_VERSION
)
abstract class RandomDatabase : RoomDatabase(){
    abstract fun getRandomDao(): RandomObjectDao
}