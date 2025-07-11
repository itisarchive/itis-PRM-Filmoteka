package pl.edu.pja.kdudek.filmoteka.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import pl.edu.pja.kdudek.filmoteka.R
import pl.edu.pja.kdudek.filmoteka.domain.model.Film
import pl.edu.pja.kdudek.filmoteka.domain.model.FilmCategory
import pl.edu.pja.kdudek.filmoteka.ui.components.ValidationMessages
import pl.edu.pja.kdudek.filmoteka.ui.components.buttons.SaveButton
import pl.edu.pja.kdudek.filmoteka.ui.components.inputs.CategoryInput
import pl.edu.pja.kdudek.filmoteka.ui.components.inputs.CommentInput
import pl.edu.pja.kdudek.filmoteka.ui.components.inputs.DateInput
import pl.edu.pja.kdudek.filmoteka.ui.components.inputs.ImageInput
import pl.edu.pja.kdudek.filmoteka.ui.components.inputs.RatingInput
import pl.edu.pja.kdudek.filmoteka.ui.components.inputs.StatusInput
import pl.edu.pja.kdudek.filmoteka.ui.components.inputs.TitleInput
import pl.edu.pja.kdudek.filmoteka.ui.viewmodel.FilmDetailViewModel
import java.time.LocalDate

@Composable
fun FilmFormScreen(
    filmId: Long?,
    navController: NavHostController,
    viewModel: FilmDetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()
    val film = uiState.film
    val validation = uiState.validationResult

    var title by remember { mutableStateOf("") }
    var releaseDate by remember { mutableStateOf(LocalDate.now()) }
    var category by remember { mutableStateOf(FilmCategory.FILM) }
    var isWatched by remember { mutableStateOf(false) }
    var rating by remember { mutableIntStateOf(0) }
    var comment by remember { mutableStateOf("") }
    var posterUri by remember { mutableStateOf("") }

    LaunchedEffect(filmId) {
        filmId?.let { viewModel.loadFilm() }
    }

    LaunchedEffect(film) {
        film?.let {
            title = it.title
            releaseDate = it.releaseDate
            category = it.category
            isWatched = it.isWatched
            rating = it.rating ?: 0
            comment = it.comment.orEmpty()
            posterUri = it.posterUri.orEmpty()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        ImageInput(
            posterUri = posterUri, onPosterUriChange = { posterUri = it })

        Spacer(modifier = Modifier.height(16.dp))

        TitleInput(
            title = title, onTitleChange = { title = it })

        Spacer(modifier = Modifier.height(8.dp))

        DateInput(
            date = releaseDate,
            onDateSelected = { releaseDate = it },
        )

        Spacer(modifier = Modifier.height(8.dp))

        CategoryInput(
            selectedCategory = category, onCategorySelected = { category = it })

        Spacer(modifier = Modifier.height(8.dp))

        StatusInput(
            status = isWatched, onCheckedChange = { isWatched = it })

        if (isWatched) {
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = stringResource(R.string.rating))

            RatingInput(
                rating = rating, onRatingChange = { rating = it })

            Spacer(modifier = Modifier.height(8.dp))

            CommentInput(
                comment = comment, onCommentChange = { comment = it })
        }

        Spacer(modifier = Modifier.height(16.dp))

        SaveButton(
            onClick = {
                val film = Film(
                    id = filmId ?: 0,
                    title = title,
                    releaseDate = releaseDate,
                    category = category,
                    isWatched = isWatched,
                    rating = if (isWatched) rating else null,
                    comment = if (isWatched) comment else null,
                    posterUri = if (posterUri.isNotEmpty()) posterUri else null
                )
                if (filmId == null) {
                    viewModel.createFilm(film) { newFilmId ->
                        if (validation == null || validation.isSuccessful) {
                            navController.navigate("film_details/$newFilmId") {
                                popUpTo("film_add") { inclusive = true }
                            }
                        }
                    }
                } else {
                    viewModel.updateFilm(film)
                    if (validation == null || validation.isSuccessful) {
                        navController.navigateUp()
                    }
                }
            }
        )

        if (validation != null && !validation.isSuccessful) {
            ValidationMessages(validation.errorMessages)
        }
    }
}
