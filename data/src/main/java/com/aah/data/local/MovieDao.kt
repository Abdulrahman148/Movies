package com.aah.data.local

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aah.data.entities.NowPlayingMovieEntity
import com.aah.data.entities.PopularMovieEntity
import com.aah.data.entities.TopRatedMovieEntity

interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovies(movieEntity: PopularMovieEntity)

    @Update
    suspend fun updateMovie(movieEntity: PopularMovieEntity)

    @Query("SELECT * FROM popularMovieEntity")
    suspend fun getPopularMoviesFromLocal() : PopularMovieEntity

    @Query("SELECT * FROM topRatedMovieEntity")
    suspend fun getTopMoviesMoviesFromLocal() : TopRatedMovieEntity

    @Query("SELECT * FROM nowPlayingMovieEntity")
    suspend fun getNowPlayingMoviesFromLocal() : NowPlayingMovieEntity
}