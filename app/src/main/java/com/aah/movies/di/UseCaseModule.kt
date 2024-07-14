package com.aah.movies.di

import com.aah.domain.repo.MovieRepo
import com.aah.domain.usecase.GetAndInsertNowPlayingMovieUseCase
import com.aah.domain.usecase.GetAndInsertPopularMovieUseCase
import com.aah.domain.usecase.GetAndInsertTopRatedMovieUseCase
import com.aah.domain.usecase.NowPlayingLocalMovieUseCase
import com.aah.domain.usecase.NowPlayingMovieUseCase
import com.aah.domain.usecase.PopularLocalMovieUseCase
import com.aah.domain.usecase.PopularMovieUseCase
import com.aah.domain.usecase.TopRatedLocalMovieUseCase
import com.aah.domain.usecase.TopRatedMovieUseCase
import com.aah.domain.usecase.UpdateNowPlayingMovieUseCase
import com.aah.domain.usecase.UpdatePopularMovieUseCase
import com.aah.domain.usecase.UpdateTopRatedMovieUseCase
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

    @Provides
    @Singleton
    fun providePopularLocalMoviesUseCase(movieRepo: MovieRepo) : PopularLocalMovieUseCase {
        return PopularLocalMovieUseCase(movieRepo)
    }

    @Provides
    @Singleton
    fun provideInsertPopularMoviesUseCase(movieRepo: MovieRepo) : GetAndInsertPopularMovieUseCase {
        return GetAndInsertPopularMovieUseCase(movieRepo)
    }

    @Provides
    @Singleton
    fun provideTopRatedLocalMoviesUseCase(movieRepo: MovieRepo) : TopRatedLocalMovieUseCase {
        return TopRatedLocalMovieUseCase(movieRepo)
    }

    @Provides
    @Singleton
    fun provideInsertTopRatedMoviesUseCase(movieRepo: MovieRepo) : GetAndInsertTopRatedMovieUseCase {
        return GetAndInsertTopRatedMovieUseCase(movieRepo)
    }

    @Provides
    @Singleton
    fun provideNowPlayingLocalMoviesUseCase(movieRepo: MovieRepo) : NowPlayingLocalMovieUseCase {
        return NowPlayingLocalMovieUseCase(movieRepo)
    }

    @Provides
    @Singleton
    fun provideInsertNowPlayingMoviesUseCase(movieRepo: MovieRepo) : GetAndInsertNowPlayingMovieUseCase {
        return GetAndInsertNowPlayingMovieUseCase(movieRepo)
    }

    @Provides
    @Singleton
    fun provideUpdatePopularMovieUseCase(movieRepo: MovieRepo) : UpdatePopularMovieUseCase {
        return UpdatePopularMovieUseCase(movieRepo)
    }

    @Provides
    @Singleton
    fun provideUpdateTopRatedMovieUseCase(movieRepo: MovieRepo) : UpdateTopRatedMovieUseCase {
        return UpdateTopRatedMovieUseCase(movieRepo)
    }

    @Provides
    @Singleton
    fun provideUpdateNowPlayingMovieUseCase(movieRepo: MovieRepo) : UpdateNowPlayingMovieUseCase {
        return UpdateNowPlayingMovieUseCase(movieRepo)
    }


}