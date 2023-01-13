package com.ridhoafni.submissioncomposedicoding.data.remote.source

import android.util.Log
import com.ridhoafni.submissioncomposedicoding.data.remote.network.MovieService
import com.ridhoafni.submissioncomposedicoding.data.remote.response.toListMovie
import com.ridhoafni.submissioncomposedicoding.data.remote.response.toMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(
    private val movieService: MovieService
) {
    suspend fun getNowPlayingMovie() = flow {
        movieService.getNowPlayingMovie().toListMovie().let { emit(it) }
    }.catch {
        Log.d("MovieRepository", "getNowPlayingMovie: failed = ${it.message}")
    }.flowOn(Dispatchers.IO)

    suspend fun getMovieDetail(id: String) = flow {
        movieService.getMovieDetail(id).toMovie().let { emit(it) }
    }.catch {
        Log.d("MovieRepository", "getMovieDetail: failed = ${it.message}")
    }.flowOn(Dispatchers.IO)
}