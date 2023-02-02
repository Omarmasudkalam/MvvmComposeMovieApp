package com.omk.movieapp.presentation.movie_details

import com.omk.movieapp.domain.model.movie_details.MovieDetails

/**
 * created by omk on 29/01/23
 */

data class DetailsMovieState(
    val isLoading: Boolean = false,
    val movieDetails: MovieDetails? = null,
    val error: String = ""
)