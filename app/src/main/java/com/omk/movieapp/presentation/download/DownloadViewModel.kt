package com.omk.movieapp.presentation.download

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omk.movieapp.common.MovieState
import com.omk.movieapp.common.Resource
import com.omk.movieapp.domain.model.all_movies.Movie
import com.omk.movieapp.domain.use_case.delete_movie.DeleteMovieUseCase
import com.omk.movieapp.domain.use_case.get_movie_local.GetLocalMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * created by omk on 29/01/23
 */

@HiltViewModel
class DownloadViewModel
@Inject constructor(
    val getLocalMoviesUseCase: GetLocalMoviesUseCase,
    val deleteMovieUseCase: DeleteMovieUseCase
) :
    ViewModel() {
    private val _state = mutableStateOf(DownloadMoviesState())
    val allMoviesState: State<DownloadMoviesState> = _state

    private val _stateDeleteMovie = mutableStateOf(MovieState())
    val stateDeleteMovie: State<MovieState> = _stateDeleteMovie


    init {
        getLocalMovie()
    }

    fun getLocalMovie() {
        getLocalMoviesUseCase().onEach { response ->
            when (response) {
                is Resource.Loading -> {
                    _state.value = DownloadMoviesState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = DownloadMoviesState(
                        allMovies = response.data as ArrayList<Movie>?,
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _state.value =
                        DownloadMoviesState(error = response.message ?: "unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
    fun updateNumberOfDownloads(){
            getLocalMoviesUseCase().onEach { response ->
                when (response) {
                    is Resource.Success -> {
                        _state.value = DownloadMoviesState(
                            numOfDowloads = response.data?.size,
                            isLoading = false
                        )
                    }
                    else -> {}
                }
            }.launchIn(viewModelScope)
        }

     fun deleteMovie(movieId: String) {
        deleteMovieUseCase(movieId).onEach { response ->
            when (response) {
                is Resource.Loading -> {
                    _stateDeleteMovie.value = MovieState(isLoading = true)
                }
                is Resource.Success -> {
                    _stateDeleteMovie.value = MovieState(isLoading = false)
                }
                is Resource.Error -> {
                    _stateDeleteMovie.value =
                        MovieState(error = response.message ?: "unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }

}