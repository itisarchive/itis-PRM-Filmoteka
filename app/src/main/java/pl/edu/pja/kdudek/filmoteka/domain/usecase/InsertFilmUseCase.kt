package pl.edu.pja.kdudek.filmoteka.domain.usecase

import pl.edu.pja.kdudek.filmoteka.data.repository.FilmRepository
import pl.edu.pja.kdudek.filmoteka.domain.model.Film

class InsertFilmUseCase(private val repository: FilmRepository) {
    suspend operator fun invoke(film: Film): Long {
        return repository.insertFilm(film)
    }
}
