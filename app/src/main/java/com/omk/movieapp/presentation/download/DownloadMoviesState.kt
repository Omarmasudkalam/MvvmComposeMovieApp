package com.omk.movieapp.presentation.download

import com.omk.movieapp.domain.model.all_movies.Movie

/**
 * created by omk on 29/01/23
 */

data class DownloadMoviesState(
    val isLoading: Boolean = false,
    val allMovies: ArrayList<Movie>? = null,
    val numOfDowloads: Int? = 0,
    val error: String = ""
)