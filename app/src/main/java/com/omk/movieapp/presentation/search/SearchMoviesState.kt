package com.omk.movieapp.presentation.search

import com.omk.movieapp.domain.model.all_movies.AllMoviesResponse
import com.omk.movieapp.domain.model.all_movies.Movie

data class SearchMoviesState(
    val isLoading: Boolean = false,
    var allMoviesResponse: List<Movie>? = null,
    val error: String = ""
)