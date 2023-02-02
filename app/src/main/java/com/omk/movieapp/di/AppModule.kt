package com.omk.movieapp.di

import android.app.Application
import androidx.room.Room
import com.omk.movieapp.common.Constants.BASE_URL
import com.omk.movieapp.data.local.MovieDB
import com.omk.movieapp.data.remote.Api
import com.omk.movieapp.data.repository.RepositoryImpl
import com.omk.movieapp.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * created by omk on 29/01/23
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Api {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api: Api, db: MovieDB): Repository {
        return RepositoryImpl(api, db = db)
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): MovieDB {
        return Room.databaseBuilder(
            app,
            MovieDB::class.java,
            MovieDB.DATABASE_NAME
        ).allowMainThreadQueries().build()
    }

}