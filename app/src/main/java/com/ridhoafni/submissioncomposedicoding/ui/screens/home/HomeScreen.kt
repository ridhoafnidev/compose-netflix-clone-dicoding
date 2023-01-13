package com.ridhoafni.submissioncomposedicoding.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.ridhoafni.submissioncomposedicoding.ui.MovieViewModel
import com.ridhoafni.submissioncomposedicoding.ui.componens.MovieAppBar
import com.ridhoafni.submissioncomposedicoding.ui.componens.MovieSearchField
import com.ridhoafni.submissioncomposedicoding.ui.screens.list.MovieGridScreen
import com.ridhoafni.submissioncomposedicoding.ui.screens.list.MovieListScreen
import com.ridhoafni.submissioncomposedicoding.utils.Routers

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: MovieViewModel = viewModel(factory = MovieViewModel.Factory)
) {
    val movies by viewModel.movies.collectAsState()

    var isGrid by remember { mutableStateOf(false) }
    var keyword by remember { mutableStateOf("") }

    LaunchedEffect("") { viewModel.getMovies() }
    LaunchedEffect(keyword) { viewModel.searchMovie(keyword) }

    Scaffold(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black),
        topBar = {
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)) {
                MovieAppBar(isTransparent = true, onViewChange = { isGrid = it })
                MovieSearchField(
                    keyword,
                    onTextChange = {
                        keyword = it
                    },
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .padding(horizontal = 16.dp)
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navHostController.navigate(Routers.PROFILE) },
            ) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Button Profile")
            }
        },
    ) { contentPadding ->
        if (isGrid) MovieGridScreen(contentPadding, movies, navHostController)
        else MovieListScreen(contentPadding, movies, navHostController)
    }
}