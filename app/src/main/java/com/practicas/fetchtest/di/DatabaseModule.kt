package com.practicas.fetchtest.di

import android.content.Context
import androidx.room.Room
import com.practicas.fetchtest.data.local.RandomDatabase
import com.practicas.fetchtest.utils.Dictionary.RANDOM_OBJECT_TABLE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, RandomDatabase::class.java, RANDOM_OBJECT_TABLE
    ).build()

    @Singleton
    @Provides
    fun provideRandomDao(db: RandomDatabase) = db.getRandomDao()
}