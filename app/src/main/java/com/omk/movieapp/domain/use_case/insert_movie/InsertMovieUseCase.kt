package com.omk.movieapp.domain.use_case.insert_movie

import com.omk.movieapp.common.Resource
import com.omk.movieapp.domain.model.all_movies.Movie
import com.omk.movieapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * created by omk on 29/01/23
 */

class InsertMovieUseCase @Inject constructor(val repository: Repository) {
    operator fun invoke(
        movie: Movie
    ): Flow<Resource<*>> = flow {
        try {
            repository.insertMovie(movie = movie)
            emit(Resource.Success<Any>("Success"))
        } catch (e: Exception) {
            emit(Resource.Error<Any>(e.localizedMessage ?: "an Error Occurred"))
        }
    }
}