package pl.edu.pja.kdudek.filmoteka.ui.viewmodel.state

import pl.edu.pja.kdudek.filmoteka.domain.model.Film
import pl.edu.pja.kdudek.filmoteka.domain.model.FilmFilter

data class FilmListState(
    val films: List<Film> = emptyList(),
    val filmCount: Int = 0,
    val filter: FilmFilter = FilmFilter()
)
