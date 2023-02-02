package com.omk.movieapp.presentation.navigation

import android.util.Log

/**
 * created by omk on 29/01/23
 */

sealed class Screens(val route:String){
    object HomeScreen :Screens("home_screen")
    object DetailsScreen :Screens("details_screen")
    object DownloadScreen :Screens("download_screen")
    object SearchScreen :Screens("search_screen")

    fun withArgs(vararg args:String):String{
       return buildString {
           append(route)
           Log.d("TAG", "withArgs: "+ args[0])
           args.forEach { _ ->
               append("/${args[0]}")
           }
       }
    }
}
