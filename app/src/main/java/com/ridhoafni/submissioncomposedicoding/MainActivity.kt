package com.ridhoafni.submissioncomposedicoding

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgs
import androidx.navigation.navArgument
import com.ridhoafni.submissioncomposedicoding.ui.screens.HomeScreen
import com.ridhoafni.submissioncomposedicoding.ui.screens.ProfileScreen
import com.ridhoafni.submissioncomposedicoding.ui.screens.detail.MovieDetailScreen
import com.ridhoafni.submissioncomposedicoding.ui.theme.NetflixCloneAppDicodingAppsTheme
import com.ridhoafni.submissioncomposedicoding.utils.Routers

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            installSplashScreen()
            NetflixCloneAppDicodingAppsTheme() {
                NetflixCloneDicodingApps()
            }
        }
    }

    @ExperimentalMaterial3Api
    @Composable
    fun NetflixCloneDicodingApps() {

        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Routers.HOME,
        ) {

            composable(
                route = Routers.HOME
            ) {
                HomeScreen(navController)
            }

            composable(
                route = "${Routers.DETAIL}/{movieId}",
                arguments = listOf(navArgument("movieId") { type = NavType.StringType })
            ) { navBackStackEntry ->
                val movieId = navBackStackEntry.arguments?.getString("movieId")
                MovieDetailScreen(movieId.orEmpty(), navController)
            }

            composable(
                route = Routers.PROFILE
            ) {
                ProfileScreen(navController)
            }
        }
    }
}

