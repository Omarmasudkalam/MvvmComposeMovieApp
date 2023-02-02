package com.omk.movieapp.presentation.home

import com.omk.movieapp.domain.model.all_movies.AllMoviesResponse

/**
 * created by omk on 29/01/23
 */

data class ListMoviesLastAddedState(
    val isLoading: Boolean = false,
    val allMoviesResponse: AllMoviesResponse? = null,
    val error: String = ""
)