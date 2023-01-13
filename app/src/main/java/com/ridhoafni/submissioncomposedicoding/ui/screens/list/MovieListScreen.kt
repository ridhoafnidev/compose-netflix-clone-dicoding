package com.ridhoafni.submissioncomposedicoding.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ridhoafni.submissioncomposedicoding.domain.model.Movie
import com.ridhoafni.submissioncomposedicoding.ui.componens.MovieItem
import com.ridhoafni.submissioncomposedicoding.utils.Routers

@ExperimentalMaterial3Api
@Composable
fun MovieListScreen(paddingValues: PaddingValues, movies: List<Movie>, navHostController: NavHostController) {
    LazyColumn(
        modifier = Modifier.padding(paddingValues)
            .background(Color.Black),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        items(movies) { movie ->
            MovieItem(
                isGrid = false,
                movie = movie,
                modifier = Modifier.padding(horizontal = 16.dp),
                onItemClick = { movie ->
                    navHostController.navigate("${Routers.DETAIL}/${movie.id}")
                }
            )
        }
    }
}