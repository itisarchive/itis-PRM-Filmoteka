package pl.edu.pja.kdudek.filmoteka.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import pl.edu.pja.kdudek.filmoteka.ui.components.Loader
import pl.edu.pja.kdudek.filmoteka.ui.components.buttons.EditFilmButton
import pl.edu.pja.kdudek.filmoteka.ui.components.fields.CategoryField
import pl.edu.pja.kdudek.filmoteka.ui.components.fields.CommentField
import pl.edu.pja.kdudek.filmoteka.ui.components.fields.PosterField
import pl.edu.pja.kdudek.filmoteka.ui.components.fields.RatingField
import pl.edu.pja.kdudek.filmoteka.ui.components.fields.ReleaseDateField
import pl.edu.pja.kdudek.filmoteka.ui.components.fields.StatusField
import pl.edu.pja.kdudek.filmoteka.ui.components.fields.TitleField
import pl.edu.pja.kdudek.filmoteka.ui.viewmodel.FilmDetailViewModel

@Composable
fun FilmDetailsScreen(
    filmId: Long?,
    navController: NavHostController,
    viewModel: FilmDetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    val film = uiState.film

    LaunchedEffect(filmId) {
        filmId?.let { viewModel.loadFilm() }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            if (film == null) {
                Loader()
                return@Column
            }

            PosterField(posterUri = film.posterUri)
            Spacer(modifier = Modifier.height(16.dp))

            TitleField(title = film.title)
            Spacer(modifier = Modifier.height(4.dp))

            ReleaseDateField(releaseDate = film.releaseDate)
            Spacer(modifier = Modifier.height(8.dp))

            CategoryField(category = film.category)
            Spacer(modifier = Modifier.height(8.dp))

            StatusField(isWatched = film.isWatched)

            if (film.isWatched) {
                Spacer(modifier = Modifier.height(8.dp))
                RatingField(rating = film.rating)
                Spacer(modifier = Modifier.height(8.dp))

                if (!film.comment.isNullOrBlank()) {
                    CommentField(comment = film.comment)
                }
            }
        }

        if (film?.isWatched == false) {
            EditFilmButton(
                filmId = film.id,
                navController = navController
            )
        }
    }
}
