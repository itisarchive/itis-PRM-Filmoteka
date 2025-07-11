package pl.edu.pja.kdudek.filmoteka.domain.model

data class FilmFilter(
    val category: FilmCategory? = null,
    val isWatched: Boolean? = null
)
