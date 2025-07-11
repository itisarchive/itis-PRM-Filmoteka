package pl.edu.pja.kdudek.filmoteka.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import pl.edu.pja.kdudek.filmoteka.data.db.FilmDao
import pl.edu.pja.kdudek.filmoteka.data.mapper.FilmMapper
import pl.edu.pja.kdudek.filmoteka.domain.model.Film
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val filmDao: FilmDao,
    private val mapper: FilmMapper
) : FilmRepository {

    override fun getAllFilms(): Flow<List<Film>> =
        filmDao.getAllFilms().map { it.map(mapper::toDomain) }

    override suspend fun getFilmById(id: Long): Film? =
        filmDao.getFilmById(id).firstOrNull()?.let(mapper::toDomain)

    override suspend fun insertFilm(film: Film): Long =
        filmDao.insertFilm(mapper.toEntity(film))

    override suspend fun updateFilm(film: Film) =
        filmDao.updateFilm(mapper.toEntity(film))

    override suspend fun deleteFilm(film: Film) =
        filmDao.deleteFilm(mapper.toEntity(film))
}
