package com.ridhoafni.submissioncomposedicoding.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ridhoafni.submissioncomposedicoding.ui.componens.MovieAppBar
import com.ridhoafni.submissioncomposedicoding.ui.componens.Profile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .padding(8.dp)
        ,
    ) {
        MovieAppBar(
            isTransparent = true,
            onBack = { navHostController.popBackStack() },
            customText = "Profile"
        )
        Profile()
    }

}