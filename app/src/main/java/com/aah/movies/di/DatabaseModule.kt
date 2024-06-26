package com.aah.movies.di

import android.content.Context
import androidx.room.Room
import com.aah.data.local.MoviesDatabase
import com.aah.data.local.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMoviesDatabase(@ApplicationContext appContext: Context) : MoviesDatabase {
        return Room.databaseBuilder(appContext, MoviesDatabase::class.java, "movies_database")
            .fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun provideMovieDao(moviesDatabase: MoviesDatabase) : MovieDao {
        return moviesDatabase.movieDao()
    }

}