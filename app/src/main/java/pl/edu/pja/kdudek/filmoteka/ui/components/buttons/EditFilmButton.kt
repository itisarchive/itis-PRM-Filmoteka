package pl.edu.pja.kdudek.filmoteka.ui.components.buttons

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BoxScope.EditFilmButton(
    filmId: Long?,
    navController: NavHostController
) {
    FloatingActionButton(
        onClick = { navController.navigate("film_edit/$filmId") },
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.Edit,
            contentDescription = "Edit film"
        )
    }
}
