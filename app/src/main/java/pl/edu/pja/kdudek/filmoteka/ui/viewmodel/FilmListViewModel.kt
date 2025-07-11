package pl.edu.pja.kdudek.filmoteka.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.edu.pja.kdudek.filmoteka.domain.model.Film
import pl.edu.pja.kdudek.filmoteka.domain.model.FilmFilter
import pl.edu.pja.kdudek.filmoteka.domain.usecase.DeleteFilmUseCase
import pl.edu.pja.kdudek.filmoteka.domain.usecase.GetAllFilmsUseCase
import pl.edu.pja.kdudek.filmoteka.domain.usecase.GetFilteredFilmsUseCase
import pl.edu.pja.kdudek.filmoteka.ui.viewmodel.state.FilmListState
import javax.inject.Inject

@HiltViewModel
class FilmListViewModel @Inject constructor(
    private val getAllFilmsUseCase: GetAllFilmsUseCase,
    private val getFilteredFilmsUseCase: GetFilteredFilmsUseCase,
    private val deleteFilmUseCase: DeleteFilmUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(FilmListState())
    val uiState: StateFlow<FilmListState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getAllFilmsUseCase().collectLatest { filmsList ->
                _uiState.update { it.copy(films = filmsList, filmCount = filmsList.size) }
            }
        }
    }

    fun updateFilter(newFilter: FilmFilter) {
        _uiState.update { it.copy(filter = newFilter) }
        viewModelScope.launch {
            getFilteredFilmsUseCase(newFilter).collectLatest { filteredFilms ->
                _uiState.update { it.copy(films = filteredFilms, filmCount = filteredFilms.size) }
            }
        }
    }

    fun deleteFilm(film: Film) {
        viewModelScope.launch {
            deleteFilmUseCase(film)
        }
    }
}
