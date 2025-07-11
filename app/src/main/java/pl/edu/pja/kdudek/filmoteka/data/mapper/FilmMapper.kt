package pl.edu.pja.kdudek.filmoteka.data.mapper

import pl.edu.pja.kdudek.filmoteka.data.db.FilmEntity
import pl.edu.pja.kdudek.filmoteka.domain.model.Film

interface FilmMapper {
    fun toDomain(entity: FilmEntity): Film
    fun toEntity(model: Film): FilmEntity
}

class FilmMapperImpl : FilmMapper {
    override fun toDomain(entity: FilmEntity) = with(entity) {
        Film(id, title, releaseDate, category, isWatched, rating, comment, posterUri)
    }

    override fun toEntity(model: Film) = with(model) {
        FilmEntity(id, title, releaseDate, category, isWatched, rating, comment, posterUri)
    }
}
