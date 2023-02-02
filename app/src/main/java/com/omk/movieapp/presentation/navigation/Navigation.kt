package com.omk.movieapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.omk.movieapp.presentation.download.DownloadScreen
import com.omk.movieapp.presentation.home.HomeScreen
import com.omk.movieapp.presentation.movie_details.MovieDetailsScreen
import com.omk.movieapp.presentation.navigation.Screens
import com.omk.movieapp.presentation.search.SearchScreen

/**
 * created by omk on 29/01/23
 */

@Composable
fun Navigation(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screens.HomeScreen.route) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navHostController = navHostController)
        }
        composable(route = Screens.DownloadScreen.route) {
            DownloadScreen(navHostController = navHostController)
        }
        composable(route = Screens.SearchScreen.route) {
            SearchScreen(navHostController = navHostController)
        }
        composable(
            route = Screens.DetailsScreen.route + "/{imdbID}", arguments = listOf(
                navArgument("imdbID") {
                    defaultValue = ""
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            MovieDetailsScreen(
                imdbID = it.arguments?.getString("imdbID"),
                navHostController = navHostController
            )
        }
    }
}