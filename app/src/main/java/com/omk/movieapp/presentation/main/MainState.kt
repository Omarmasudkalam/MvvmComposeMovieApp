package com.omk.movieapp.presentation.main

/**
 * created by omk on 29/01/23
 */

data class MainState(
    val isLoading: Boolean = false,
    val numberOfDownloads: String? = null,
    val error: String = ""
)