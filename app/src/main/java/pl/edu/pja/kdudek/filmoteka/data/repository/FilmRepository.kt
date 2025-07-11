package pl.edu.pja.kdudek.filmoteka.data.repository

import kotlinx.coroutines.flow.Flow
import pl.edu.pja.kdudek.filmoteka.domain.model.Film

interface FilmRepository {
    fun getAllFilms(): Flow<List<Film>>
    suspend fun getFilmById(id: Long): Film?
    suspend fun insertFilm(film: Film): Long
    suspend fun updateFilm(film: Film)
    suspend fun deleteFilm(film: Film)
}
