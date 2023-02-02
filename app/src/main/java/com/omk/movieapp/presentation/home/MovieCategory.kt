package com.omk.movieapp.presentation.home

/**
 * created by omk on 29/01/23
 */

enum class MovieCategory(val value: String) {
    Action("Action"),
    Adventure("Adventure"),
    Comedy("Comedy"),
    Romance("Romance"),
    Fantasy("Fantasy")
}

fun getAllCategories(): List<MovieCategory> {
    return listOf(
        MovieCategory.Action,
        MovieCategory.Adventure,
        MovieCategory.Comedy,
        MovieCategory.Romance,
        MovieCategory.Fantasy
    )
}

fun getCategory(category: String?): MovieCategory? {
    val map = MovieCategory.values().associateBy(MovieCategory::value)
    return map[category]
}