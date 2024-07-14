package com.aah.data.mappers
import com.aah.data.local.entities.NowPlayingMovieEntity
import com.aah.data.local.entities.PopularMovieEntity
import com.aah.data.local.entities.TopRatedMovieEntity
import com.aah.domain.model.Result

fun Result.mapToEntity(): PopularMovieEntity {
    return PopularMovieEntity(
        adult = this.adult,
        backdropPath = this.backdrop_path,
        genreIds = this.genre_ids,
        id = this.id,
        originalLanguage = this.original_language,
        originalTitle = this.original_title,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.poster_path,
        releaseDate = this.release_date,
        title = this.title,
        video = this.video,
        voteAverage = this.vote_average,
        voteCount = this.vote_count,
        isFavourite = this.isFavourites
    )
}

fun Result.mapToTopRatedEntity(): TopRatedMovieEntity {
    return TopRatedMovieEntity(
        adult = this.adult,
        backdropPath = this.backdrop_path,
        genreIds = this.genre_ids,
        id = this.id,
        originalLanguage = this.original_language,
        originalTitle = this.original_title,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.poster_path,
        releaseDate = this.release_date,
        title = this.title,
        video = this.video,
        voteAverage = this.vote_average,
        voteCount = this.vote_count,
        isFavourite = this.isFavourites
    )
}

fun Result.mapToNowPlayingEntity(): NowPlayingMovieEntity {
    return NowPlayingMovieEntity(
        adult = this.adult,
        backdropPath = this.backdrop_path,
        genreIds = this.genre_ids,
        id = this.id,
        originalLanguage = this.original_language,
        originalTitle = this.original_title,
        overview = this.overview,
        popularity = this.popularity,
        posterPath = this.poster_path,
        releaseDate = this.release_date,
        title = this.title,
        video = this.video,
        voteAverage = this.vote_average,
        voteCount = this.vote_count,
        isFavourite = this.isFavourites
    )
}



fun PopularMovieEntity.mopToDomain() : Result {
    return Result(
        adult = this.adult,
        backdrop_path = this.backdropPath,
        genre_ids = this.genreIds,
        id = this.id,
        original_language = this.originalLanguage,
        original_title = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        poster_path = this.posterPath,
        release_date = this.releaseDate,
        title = this.title,
        video = this.video,
        vote_average = this.voteAverage,
        vote_count = this.voteCount,
        isFavourites = this.isFavourite
    )
}

fun TopRatedMovieEntity.mopToDomain() : Result {
    return Result(
        adult = this.adult,
        backdrop_path = this.backdropPath,
        genre_ids = this.genreIds,
        id = this.id,
        original_language = this.originalLanguage,
        original_title = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        poster_path = this.posterPath,
        release_date = this.releaseDate,
        title = this.title,
        video = this.video,
        vote_average = this.voteAverage,
        vote_count = this.voteCount,
        isFavourites = this.isFavourite
    )
}

fun NowPlayingMovieEntity.mopToDomain() : Result {
    return Result(
        adult = this.adult,
        backdrop_path = this.backdropPath ?: "",
        genre_ids = this.genreIds,
        id = this.id,
        original_language = this.originalLanguage,
        original_title = this.originalTitle,
        overview = this.overview,
        popularity = this.popularity,
        poster_path = this.posterPath,
        release_date = this.releaseDate,
        title = this.title,
        video = this.video,
        vote_average = this.voteAverage,
        vote_count = this.voteCount,
        isFavourites = this.isFavourite
    )
}