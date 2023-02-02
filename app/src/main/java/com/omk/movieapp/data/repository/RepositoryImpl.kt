package com.omk.movieapp.data.repository

import com.omk.movieapp.data.local.MovieDB
import com.omk.movieapp.data.remote.Api
import com.omk.movieapp.domain.model.all_movies.AllMoviesResponse
import com.omk.movieapp.domain.model.all_movies.Movie
import com.omk.movieapp.domain.model.movie_details.MovieDetails
import com.omk.movieapp.domain.repository.Repository
import javax.inject.Inject

/**
 * created by omk on 29/01/23
 */

class RepositoryImpl @Inject constructor(val api: Api,private val db: MovieDB) : Repository {
    override suspend fun getMovies(movie: String, apikey: String, page: Int): AllMoviesResponse? {
        return api.getMovies(movie, apikey, page)
    }

    override suspend fun getMovieDetailsById(imdbID: String, apikey: String): MovieDetails? {
        return api.getMovieDetailsById(imdbID, apikey)
    }

    override suspend fun insertMovie(movie: Movie) {
        db.movieDao.insert(movie)
    }

    override suspend fun deleteMovie(movieId: String) {
        db.movieDao.deleteMovie(movieId)
    }
    override suspend fun getDownloads(): List<Movie> {
        return db.movieDao.getMovies()
    }


}