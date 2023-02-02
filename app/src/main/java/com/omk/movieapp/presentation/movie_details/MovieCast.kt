package com.omk.movieapp.presentation.movie_details
import com.omk.movieapp.R

/**
 * created by omk on 29/01/23
 */

enum class MovieCast(val img: Int) {
    MatthewMercer(R.drawable.img1),
    DavidVincent(R.drawable.img2),
    DaisukeOno(R.drawable.img3),
    UnshodShizuka(R.drawable.img4),
    PhillipReich(R.drawable.img5)
}

fun getAllCast(): List<MovieCast> {
    return listOf(
        MovieCast.DaisukeOno,
        MovieCast.DavidVincent,
        MovieCast.MatthewMercer,
        MovieCast.PhillipReich,
        MovieCast.UnshodShizuka
    )
}