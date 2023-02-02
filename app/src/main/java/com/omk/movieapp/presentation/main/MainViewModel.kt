package com.omk.movieapp.presentation.main


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omk.movieapp.common.Resource
import com.omk.movieapp.domain.use_case.get_movie_local.GetLocalMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * created by omk on 29/01/23
 */

@HiltViewModel
class MainViewModel
@Inject constructor(val getLocalMoviesUseCase: GetLocalMoviesUseCase) :ViewModel(){
    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state

    init {
        getLocalMovie()
    }
     fun getLocalMovie() {
        getLocalMoviesUseCase().onEach { response ->
            when (response) {
                is Resource.Success -> {
                    _state.value = MainState(
                        numberOfDownloads = response.data?.size.toString(),
                        isLoading = false
                    )
                }
                else -> {}
            }
        }.launchIn(viewModelScope)
    }
}