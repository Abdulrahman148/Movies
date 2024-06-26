package com.aah.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aah.data.local.entities.NowPlayingMovieEntity
import com.aah.data.local.entities.PopularMovieEntity
import com.aah.data.local.entities.TopRatedMovieEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMovies(movieEntity: List<PopularMovieEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTopRatedMovies(movieEntity: List<TopRatedMovieEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNowPlayingMovies(movieEntity: List<NowPlayingMovieEntity>)

    @Update
    suspend fun updateMovie(movieEntity: PopularMovieEntity)

    @Query("SELECT * FROM popularMovieEntity")
    suspend fun getPopularMoviesFromLocal() : List<PopularMovieEntity>

    @Query("SELECT * FROM topRatedMovieEntity")
    suspend fun getTopRatedMoviesFromLocal() : List<TopRatedMovieEntity>

    @Query("SELECT * FROM nowPlayingMovieEntity")
    suspend fun getNowPlayingMoviesFromLocal() : List<NowPlayingMovieEntity>
}