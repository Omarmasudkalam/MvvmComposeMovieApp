package com.omk.movieapp.domain.repository

import com.omk.movieapp.domain.model.all_movies.AllMoviesResponse
import com.omk.movieapp.domain.model.all_movies.Movie
import com.omk.movieapp.domain.model.movie_details.MovieDetails

/**
 * created by omk on 29/01/23
 */

interface Repository {
    suspend fun getMovies(
        movie: String, apikey: String, page: Int
    ): AllMoviesResponse?

    suspend fun getMovieDetailsById(imdbID: String, apikey: String): MovieDetails?

    suspend fun insertMovie(movie: Movie)
    suspend fun deleteMovie(movieId: String)
    suspend fun getDownloads(): List<Movie>?

}