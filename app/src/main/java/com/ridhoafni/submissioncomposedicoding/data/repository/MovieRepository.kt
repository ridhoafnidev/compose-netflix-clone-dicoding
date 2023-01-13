package com.ridhoafni.submissioncomposedicoding.data.repository

import com.ridhoafni.submissioncomposedicoding.data.remote.source.RemoteDataSource
import com.ridhoafni.submissioncomposedicoding.domain.model.Movie
import com.ridhoafni.submissioncomposedicoding.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepository(
    private val remoteDataSource: RemoteDataSource
) : IMovieRepository {
    override suspend fun getNowPlayingMovie(): Flow<List<Movie>> =
        remoteDataSource.getNowPlayingMovie()

    override suspend fun getMovieDetail(id: String): Flow<Movie> =
        remoteDataSource.getMovieDetail(id)
}