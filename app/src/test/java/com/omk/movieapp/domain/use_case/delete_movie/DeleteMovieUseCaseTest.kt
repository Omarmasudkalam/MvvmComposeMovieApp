package com.omk.movieapp.domain.use_case.delete_movie

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.omk.movieapp.data.repository.FakeRepository
import com.omk.movieapp.domain.model.all_movies.Movie
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * created by omk on 29/01/23
 */

class DeleteMovieUseCaseTest {
    private lateinit var fakeRepository: FakeRepository
    private val moviesToInsert = mutableListOf<Movie>()
    private lateinit var deleteMovieUseCase: DeleteMovieUseCase

    @Before
    fun setUp() {
        fakeRepository = FakeRepository()
        deleteMovieUseCase =DeleteMovieUseCase(fakeRepository)
        moviesToInsert.add(Movie(1, "", "Movie1", "Action", "1990", "1"))
        runBlocking { moviesToInsert.forEach { fakeRepository.insertMovie(it) } }
    }

    @Test
    fun `delete Movie, return True`() = runBlocking {
        deleteMovieUseCase.invoke("1").test {
            Truth.assertThat(awaitItem().data).isEqualTo("Success")
            cancelAndConsumeRemainingEvents()
        }
    }

}