package com.ridhoafni.submissioncomposedicoding.domain.repository

import com.ridhoafni.submissioncomposedicoding.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    suspend fun getNowPlayingMovie(): Flow<List<Movie>>
    suspend fun getMovieDetail(id: String): Flow<Movie>
}