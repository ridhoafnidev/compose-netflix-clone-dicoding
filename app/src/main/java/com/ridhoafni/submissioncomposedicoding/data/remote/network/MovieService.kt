package com.ridhoafni.submissioncomposedicoding.data.remote.network

import com.ridhoafni.submissioncomposedicoding.data.remote.response.ListMovieResponse
import com.ridhoafni.submissioncomposedicoding.data.remote.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(
        @Query("api_key") apiKey: String = "0a597bad68c0b95d5fab612cff9d8891",
        @Query("language") language: String = "en-US"
    ): ListMovieResponse

    @GET("movie/{movieId}")
    suspend fun getMovieDetail(
        @Path("movieId") movieId: String,
        @Query("api_key") apiKey: String = "0a597bad68c0b95d5fab612cff9d8891"
    ): MovieResponse

}