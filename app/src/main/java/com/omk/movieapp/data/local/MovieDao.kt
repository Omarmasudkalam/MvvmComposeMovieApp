package com.omk.movieapp.data.local

/**
 * created by omk on 29/01/23
 */

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.omk.movieapp.domain.model.all_movies.Movie

@Dao
interface MovieDao {
    @Insert
    suspend fun insert(movie: Movie)

    @Query("delete from Download where imdbID =:imdbID")
    suspend fun deleteMovie(imdbID: String)

    @Query("SELECT * FROM Download")
    suspend fun getMovies(): List<Movie>

}