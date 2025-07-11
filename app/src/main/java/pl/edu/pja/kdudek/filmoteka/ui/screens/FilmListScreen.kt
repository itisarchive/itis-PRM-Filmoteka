package pl.edu.pja.kdudek.filmoteka.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import pl.edu.pja.kdudek.filmoteka.domain.model.Film
import pl.edu.pja.kdudek.filmoteka.domain.model.FilmFilter
import pl.edu.pja.kdudek.filmoteka.ui.components.DeleteDialog
import pl.edu.pja.kdudek.filmoteka.ui.components.FilmCard
import pl.edu.pja.kdudek.filmoteka.ui.components.MovieCounter
import pl.edu.pja.kdudek.filmoteka.ui.components.buttons.FilterButton
import pl.edu.pja.kdudek.filmoteka.ui.viewmodel.FilmListViewModel

@Composable
fun FilmListScreen(
    navController: NavHostController,
    viewModel: FilmListViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val films = uiState.films
    val filmCount = uiState.filmCount
    val currentFilter = uiState.filter

    var showDeleteDialog by remember { mutableStateOf(false) }
    var filmToDelete by remember { mutableStateOf<Film?>(null) }

    var selectedCategory by remember { mutableStateOf(currentFilter.category) }
    var selectedWatched by remember { mutableStateOf(currentFilter.isWatched) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surfaceBright
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                FilterButton(
                    selectedCategory = selectedCategory,
                    selectedWatched = selectedWatched,
                    onCategorySelected = { newCategory ->
                        selectedCategory = newCategory
                        viewModel.updateFilter(
                            FilmFilter(
                                category = newCategory,
                                isWatched = selectedWatched
                            )
                        )
                    },
                    onWatchedSelected = { newWatched ->
                        selectedWatched = newWatched
                        viewModel.updateFilter(
                            FilmFilter(
                                category = selectedCategory,
                                isWatched = newWatched
                            )
                        )
                    }
                )

                MovieCounter(filmCount)
            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn {
                items(films, key = { it.id }) { film ->
                    FilmCard(
                        film = film,
                        onClick = {
                            navController.navigate("film_details/${film.id}")
                        },
                        onLongClick = {
                            filmToDelete = film
                            showDeleteDialog = true
                        }
                    )
                }
            }
        }

        if (showDeleteDialog && filmToDelete != null) {
            DeleteDialog(
                film = filmToDelete!!,
                onDelete = { film ->
                    viewModel.deleteFilm(film)
                    showDeleteDialog = false
                    filmToDelete = null
                },
                onDismiss = {
                    showDeleteDialog = false
                    filmToDelete = null
                }
            )
        }
    }
}
