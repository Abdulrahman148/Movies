package com.aah.domain.usecase


import com.aah.domain.model.Result
import com.aah.domain.repo.MovieRepo

class GetAndInsertPopularMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke() = movieRepo.getAndInsertPopularMovieFromApi()
}

class GetAndInsertTopRatedMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke() = movieRepo.getAndInsertTopRatedMovieFromApi()
}

class GetAndInsertNowPlayingMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke() = movieRepo.getAndInsertNowPlayingMovieFromApi()
}


class PopularMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke() = movieRepo.getPopularMoviesFromApi()
}


class TopRatedMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke() = movieRepo.getTopRatedMoviesFromApi()
}

class NowPlayingMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke() = movieRepo.getNowPlayingMovieFromApi()
}

class PopularLocalMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke() = movieRepo.getPopularMovieFromLocal()
}

class TopRatedLocalMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke() = movieRepo.getTopRatedMovieFromLocal()
}

class NowPlayingLocalMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke() = movieRepo.getNowPlayingMovieFromLocal()
}

class UpdatePopularMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke(popularEntity: Result) = movieRepo.updatePopularMovie(popularEntity)
}

class UpdateTopRatedMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke(topRatedEntity: Result) = movieRepo.updateTopRatedMovie(topRatedEntity)
}

class UpdateNowPlayingMovieUseCase(private val movieRepo: MovieRepo) {
    suspend operator fun invoke(nowPlayingEntity: Result) = movieRepo.updateNowPlayingMovie(nowPlayingEntity)
}