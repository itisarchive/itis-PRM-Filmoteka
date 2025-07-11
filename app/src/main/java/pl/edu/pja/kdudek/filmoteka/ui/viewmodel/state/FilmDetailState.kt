package pl.edu.pja.kdudek.filmoteka.ui.viewmodel.state

import pl.edu.pja.kdudek.filmoteka.domain.model.Film
import pl.edu.pja.kdudek.filmoteka.domain.model.ValidationResult

data class FilmDetailState(
    val film: Film? = null,
    val validationResult: ValidationResult? = null
)
