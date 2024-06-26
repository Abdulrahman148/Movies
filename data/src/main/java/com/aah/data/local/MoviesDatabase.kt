package com.aah.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aah.data.local.entities.Converters
import com.aah.data.local.entities.NowPlayingMovieEntity
import com.aah.data.local.entities.PopularMovieEntity
import com.aah.data.local.entities.TopRatedMovieEntity
import com.aah.data.local.MovieDao

@TypeConverters(Converters::class)
@Database(entities = [PopularMovieEntity::class, TopRatedMovieEntity::class, NowPlayingMovieEntity::class],
                        version = 1,
                        exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}