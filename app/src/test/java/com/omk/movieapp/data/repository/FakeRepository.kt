package com.omk.movieapp.data.repository

import com.omk.movieapp.domain.model.all_movies.AllMoviesResponse
import com.omk.movieapp.domain.model.all_movies.Movie
import com.omk.movieapp.domain.model.movie_details.MovieDetails
import com.omk.movieapp.domain.repository.Repository

class FakeRepository : Repository {
    private var movies = mutableListOf<Movie>()
    private var allMovies = mutableListOf<MovieDetails>()
    private var allDownloads = mutableListOf<Movie>()
    private val response = "Success"
    private val movieResponse = AllMoviesResponse(movies = movies, Response = response)

    override suspend fun getMovies(movie: String, apikey: String, page: Int): AllMoviesResponse {
        return movieResponse
    }

    override suspend fun getMovieDetailsById(imdbID: String, apikey: String): MovieDetails? {
        return allMovies.find { it.imdbID == imdbID }
    }

    override suspend fun insertMovie(movie: Movie) {
        allDownloads.add(movie)
    }

    override suspend fun deleteMovie(movieId: String) {
        val movie = allDownloads.find { it.id.toString() == movieId }
        allDownloads.remove(movie)
    }

    override suspend fun getDownloads(): List<Movie> {
        return allDownloads
    }

}