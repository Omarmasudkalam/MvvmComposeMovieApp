package com.omk.movieapp.data.local

/**
 * created by omk on 29/01/23
 */

import androidx.room.*
import com.omk.movieapp.domain.model.all_movies.Movie
import com.omk.movieapp.domain.model.all_movies.TypeConverterMovie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverterMovie::class)
abstract class MovieDB : RoomDatabase() {
    abstract val movieDao: MovieDao
    companion object {
        const val DATABASE_NAME = "Movie_db"
    }
}