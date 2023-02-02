package com.omk.movieapp.presentation.download.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import com.omk.movieapp.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.omk.movieapp.domain.model.all_movies.Movie

/**
 * created by omk on 29/01/23
 */

@Composable
fun DownloadItem(
    movies: Movie, onExecuteMovie: (String) -> Unit
) {

    Row(modifier = Modifier
        .padding(end = 5.dp, bottom = 10.dp)
        .fillMaxWidth()) {
        Card(
            shape = RoundedCornerShape(10.dp),
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .background(Color.LightGray)
                    .size(100.dp)
                    .clickable { onExecuteMovie(movies.imdbID) }

            ) {
                Image(
                    painter = rememberAsyncImagePainter(movies.Poster),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                )

                Card(
                    elevation = 4.dp,
                    shape = CircleShape,
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_play),
                            contentDescription = "Profile",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(20.dp)
                                .clip(CircleShape)
                        )
                    }
                }


            }

        }
        Column(Modifier.padding(start = 10.dp)) {
            Text(
                movies.Title,
                textAlign = TextAlign.Start,
                maxLines = 1,
                modifier = Modifier
                    .padding(
                        top = 5.dp,
                        bottom = 5.dp,
                        end = 12.dp
                    )
                    .width(150.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(
                        Font(R.font.font_bold)
                    )

                )
            )
            Text(
                movies.Year,
                textAlign = TextAlign.Start,
                maxLines = 1,
                modifier = Modifier
                    .padding(
                        top = 5.dp,
                        bottom = 5.dp,
                        end = 12.dp
                    )
                    .width(150.dp),
                style = TextStyle(
                    fontSize = 10.sp,
                    color = Color.Gray,
                    fontFamily = FontFamily(
                        Font(R.font.font_bold)
                    )

                )
            )

        }

    }


}


