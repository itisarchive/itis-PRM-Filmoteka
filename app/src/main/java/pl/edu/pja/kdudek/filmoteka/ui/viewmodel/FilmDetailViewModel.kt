package pl.edu.pja.kdudek.filmoteka.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.edu.pja.kdudek.filmoteka.domain.model.Film
import pl.edu.pja.kdudek.filmoteka.domain.usecase.GetFilmByIdUseCase
import pl.edu.pja.kdudek.filmoteka.domain.usecase.InsertFilmUseCase
import pl.edu.pja.kdudek.filmoteka.domain.usecase.UpdateFilmUseCase
import pl.edu.pja.kdudek.filmoteka.domain.usecase.ValidateFilmUseCase
import pl.edu.pja.kdudek.filmoteka.ui.viewmodel.state.FilmDetailState
import javax.inject.Inject

@HiltViewModel
class FilmDetailViewModel @Inject constructor(
    private val getFilmByIdUseCase: GetFilmByIdUseCase,
    private val validateFilmUseCase: ValidateFilmUseCase,
    private val updateFilmUseCase: UpdateFilmUseCase,
    private val insertFilmUseCase: InsertFilmUseCase,
    saveStateHandle: SavedStateHandle
) : ViewModel() {

    private val filmId: Long? = saveStateHandle.get<Long>("filmId")
    private val _state = MutableStateFlow(FilmDetailState())
    val state: StateFlow<FilmDetailState> = _state.asStateFlow()

    fun loadFilm() {
        filmId?.let { id ->
            viewModelScope.launch {
                val film = getFilmByIdUseCase(id)
                _state.update { oldState ->
                    oldState.copy(film = film)
                }
            }
        }
    }

    fun updateFilm(updatedFilm: Film) {
        val result = validateFilmUseCase(updatedFilm)
        _state.update { oldState ->
            oldState.copy(validationResult = result)
        }
        if (result.isSuccessful) {
            viewModelScope.launch {
                updateFilmUseCase(updatedFilm)
                _state.update { oldState ->
                    oldState.copy(film = updatedFilm)
                }
            }
        }
    }

    fun createFilm(newFilm: Film, onResult: (Long) -> Unit) {
        val result = validateFilmUseCase(newFilm)
        _state.update { oldState ->
            oldState.copy(validationResult = result)
        }
        if (result.isSuccessful) {
            viewModelScope.launch {
                val newId = insertFilmUseCase(newFilm)
                val filmWithId = newFilm.copy(id = newId)
                _state.update { oldState ->
                    oldState.copy(film = filmWithId)
                }
                onResult(newId)
            }
        }
    }
}
