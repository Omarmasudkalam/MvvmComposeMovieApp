package com.omk.movieapp.common

/**
 * created by omk on 29/01/23
 */

data class MovieState(
    val isLoading: Boolean = false,
    val error: String = ""
)