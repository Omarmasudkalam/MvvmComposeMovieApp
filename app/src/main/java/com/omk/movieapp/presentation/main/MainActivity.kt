package com.omk.movieapp.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import com.omk.movieapp.R
import com.omk.movieapp.presentation.download.DownloadViewModel
import com.omk.movieapp.presentation.navigation.Navigation
import com.omk.movieapp.presentation.navigation.Screens

/**
 * created by omk on 29/01/23
 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(

                bottomBar = {
                    BottomNavigationBar(
                        navController = navController,
                        items = listOf(
                            BottomNavigationItem(
                                stringResource(id = R.string.home),
                                Screens.HomeScreen.route,
                                R.drawable.ic_home
                            ),
                            BottomNavigationItem(
                                stringResource(id = R.string.download),
                                Screens.DownloadScreen.route,
                                R.drawable.ic_baseline_add
                            ),
                        ),
                        onItemClick = { navController.navigate(route = it.route) },
                        modifier = Modifier
                    )
                }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.White,
                                    Color.White,
                                    colorResource(id = R.color.back_main)
                                ), startY = 100f
                            )
                        )
                ) {
                    Navigation(navHostController = navController)
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    navController: NavController,
    modifier: Modifier,
    onItemClick: (BottomNavigationItem) -> Unit,
    viewModel: MainViewModel = hiltViewModel(),
    downloadViewModel: DownloadViewModel= hiltViewModel()
) {
    val state = viewModel.state.value
    BottomNavigation(
        modifier = modifier,
        colorResource(id = R.color.white),
        elevation = 5.dp
    ) {
        items.forEach {
            var selected =
                it.route == navController.currentBackStackEntryAsState().value?.destination?.route

            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(it) },
                selectedContentColor = colorResource(id = R.color.purple_200),
                unselectedContentColor = Color.Black,
                icon = {
                    Column(modifier = Modifier.padding(top=10.dp)) {
                        if (it.route == Screens.DownloadScreen.route) {
                            BadgeBox(
                                badgeContent = {
                                    Text(text = downloadViewModel.allMoviesState.value.numOfDowloads.toString() )
                                }
                            ) {
                                Icon(
                                    painterResource(id = it.icon),
                                    modifier=Modifier.align(Alignment.Center),
                                    contentDescription = it.name
                                )
                            }
                        }else{
                            Icon(
                                painterResource(id = it.icon),
                                modifier=Modifier.align(Alignment.CenterHorizontally),
                                contentDescription = it.name
                            )
                        }

                        Text(
                            text = it.name,
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily(Font(R.font.font_bold)),
                            style = TextStyle(fontSize = 10.sp)
                        )
                    }
                }
            )
        }
    }
}
