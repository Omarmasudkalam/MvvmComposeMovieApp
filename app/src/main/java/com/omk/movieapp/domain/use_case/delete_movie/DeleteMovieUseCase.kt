package com.omk.movieapp.domain.use_case.delete_movie

import com.omk.movieapp.common.Resource
import com.omk.movieapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * created by omk on 29/01/23
 */

class DeleteMovieUseCase @Inject constructor(val repository: Repository) {
    operator fun invoke(
        imdbID: String
    ): Flow<Resource<*>> = flow {
        try {
            repository.deleteMovie(imdbID)
            emit(Resource.Success<Any>("Success"))
        } catch (e: Exception) {
            emit(Resource.Error<Any>(e.localizedMessage ?: "an Error Occurred"))
        }
    }
}