package com.omk.movieapp.domain.use_case.insert_movie

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.omk.movieapp.data.repository.FakeRepository
import com.omk.movieapp.domain.model.all_movies.Movie
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * created by omk on 29/01/23
 */

class InsertMovieUseCaseTest {
    private lateinit var insertMovieUseCase: InsertMovieUseCase
    private lateinit var fakeRepository: FakeRepository

    @Before
    fun setUp() {
        fakeRepository = FakeRepository()
        insertMovieUseCase = InsertMovieUseCase(fakeRepository)
    }

    @Test
    fun `insert Movie, return True`() = runBlocking {
        insertMovieUseCase.invoke(Movie(1, "", "test", "Action", "1990", "1")).test {
            assertThat(awaitItem().data).isEqualTo("Success")
            cancelAndConsumeRemainingEvents()
        }
    }
}