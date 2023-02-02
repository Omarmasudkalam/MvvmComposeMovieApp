package com.omk.movieapp.data.remote

import com.omk.movieapp.domain.model.all_movies.AllMoviesResponse
import com.omk.movieapp.domain.model.movie_details.MovieDetails
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * created by omk on 29/01/23
 */

interface Api {
    @GET(".")
    suspend fun getMovies(
        @Query("s") movie: String,
        @Query("apikey") apikey: String,
        @Query("page") page: Int
    ): AllMoviesResponse?

    @GET(".")
    suspend fun getMovieDetailsById(
        @Query("i") movie: String,
        @Query("apikey") apikey: String,
    ): MovieDetails?
}