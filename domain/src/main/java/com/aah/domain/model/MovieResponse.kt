package com.aah.domain.model

data class MovieResponse(
    val page: Int,
    val results: ArrayList<Result>,
    val total_pages: Int,
    val total_results: Int
)