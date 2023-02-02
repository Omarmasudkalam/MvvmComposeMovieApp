package com.omk.movieapp.domain.model.all_movies

import com.google.gson.annotations.SerializedName

/**
 * created by omk on 29/01/23
 */

data class AllMoviesResponse(
    val Response: String?,
    @SerializedName("Search")
    var movies: List<Movie>?
)