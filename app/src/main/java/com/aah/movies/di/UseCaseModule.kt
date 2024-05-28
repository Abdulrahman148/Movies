package com.aah.movies.di

import com.aah.domain.repo.MovieRepo
import com.aah.domain.usecase.NowPlayingMovieUseCase
import com.aah.domain.usecase.PopularMovieUseCase
import com.aah.domain.usecase.TopRatedMovieUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(movieRepo: MovieRepo) : PopularMovieUseCase {
        return PopularMovieUseCase(movieRepo)
    }

    @Provides
    @Singleton
    fun provideTopRatedMoviesUseCase(movieRepo: MovieRepo) : TopRatedMovieUseCase {
        return TopRatedMovieUseCase((movieRepo))
    }

    @Provides
    @Singleton
    fun provideNowPlayingMoviesUseCase(movieRepo: MovieRepo) : NowPlayingMovieUseCase {
        return NowPlayingMovieUseCase(movieRepo)
    }

}