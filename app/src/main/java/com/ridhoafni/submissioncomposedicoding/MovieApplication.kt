package com.ridhoafni.submissioncomposedicoding

import android.app.Application
import com.ridhoafni.submissioncomposedicoding.data.AppMovieContainer
import com.ridhoafni.submissioncomposedicoding.data.DefaultAppMovieContainer

class MovieApplication : Application() {
    lateinit var appMovieContainer: AppMovieContainer
    override fun onCreate() {
        super.onCreate()
        appMovieContainer = DefaultAppMovieContainer(context = applicationContext)
    }
}