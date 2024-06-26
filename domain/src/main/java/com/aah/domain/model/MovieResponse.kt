package com.aah.domain.model

data class MovieResponse(
    val page: Int,
    var results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)