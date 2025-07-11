package pl.edu.pja.kdudek.filmoteka.domain.model

import java.time.LocalDate

data class Film(
    val id: Long,
    val title: String,
    val releaseDate: LocalDate,
    val category: FilmCategory,
    val isWatched: Boolean,
    val rating: Int?,
    val comment: String?,
    val posterUri: String?
)
