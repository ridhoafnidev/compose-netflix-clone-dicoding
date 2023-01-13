package com.ridhoafni.submissioncomposedicoding.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ridhoafni.submissioncomposedicoding.MovieApplication
import com.ridhoafni.submissioncomposedicoding.data.repository.MovieRepository
import com.ridhoafni.submissioncomposedicoding.domain.model.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MovieApplication)
                MovieViewModel(application.appMovieContainer.movieRepository)
            }
        }
    }

    private val _movies = MutableStateFlow(emptyList<Movie>())
    val movies: StateFlow<List<Movie>> get() = _movies

    private val currentMovie = mutableListOf<Movie>()

    private val _movie = MutableStateFlow<Movie?>(null)
    val movie: StateFlow<Movie?> get() = _movie

    fun getMovies() {
        viewModelScope.launch {
            movieRepository.getNowPlayingMovie().collect {
                currentMovie.clear()
                currentMovie.addAll(it)
                _movies.value = currentMovie
            }
        }
    }

    fun searchMovie(keyword: String) {
        _movies.value = currentMovie.filter { movie ->
            movie.title.contains(keyword, true) || movie.description.contains(keyword, true)
        }
    }

    fun getMovieDetail(id: String) {
        viewModelScope.launch {
            movieRepository.getMovieDetail(id).collect {
                _movie.value = it
            }
        }
    }

}