package pl.edu.pja.kdudek.filmoteka.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import pl.edu.pja.kdudek.filmoteka.ui.screens.FilmDetailsScreen
import pl.edu.pja.kdudek.filmoteka.ui.screens.FilmFormScreen
import pl.edu.pja.kdudek.filmoteka.ui.screens.FilmListScreen

@Composable
fun Router(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = "film_list",
        modifier = Modifier.padding(innerPadding)
    ) {
        composable("film_list") {
            FilmListScreen(navController = navController)
        }
        composable(
            "film_details/{filmId}",
            arguments = listOf(navArgument("filmId") {
                type = NavType.LongType
                defaultValue = 0
            })
        ) { backStackEntry ->
            val filmId = backStackEntry.arguments?.getLong("filmId")
            FilmDetailsScreen(
                filmId = filmId,
                navController = navController
            )
        }
        composable(
            "film_edit/{filmId}",
            arguments = listOf(navArgument("filmId") {
                type = NavType.LongType
                defaultValue = 0
            })
        ) { backStackEntry ->
            val filmId = backStackEntry.arguments?.getLong("filmId")
            FilmFormScreen(filmId = filmId, navController = navController)
        }
        composable("film_add") {
            FilmFormScreen(filmId = null, navController = navController)
        }
    }
}
