package com.omk.movieapp.domain.use_case.get_movie_local

import com.omk.movieapp.common.Resource
import com.omk.movieapp.domain.model.all_movies.Movie
import com.omk.movieapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * created by omk on 29/01/23
 */

class GetLocalMoviesUseCase @Inject constructor(val repository: Repository) {
    operator fun invoke(
    ): Flow<Resource<List<Movie>>> = flow {
        try {
            val movies = repository.getDownloads()
            emit(Resource.Success<List<Movie>>(movies))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Movie>>(e.localizedMessage ?: "an Error Occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Movie>>("No Internet Connection, Check your Internet"))
        }
    }
}