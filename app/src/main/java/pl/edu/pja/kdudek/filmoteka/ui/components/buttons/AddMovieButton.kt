package pl.edu.pja.kdudek.filmoteka.ui.components.buttons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import pl.edu.pja.kdudek.filmoteka.R

@Composable
fun AddMovieButton(navController: NavHostController) {
    FloatingActionButton(
        onClick = { navController.navigate("film_add") }
    ) {
        Icon(Icons.Default.Add, contentDescription = stringResource(R.string.add_movie))
    }
}
