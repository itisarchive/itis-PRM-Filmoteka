package pl.edu.pja.kdudek.filmoteka.domain.usecase

import pl.edu.pja.kdudek.filmoteka.data.repository.FilmRepository
import pl.edu.pja.kdudek.filmoteka.domain.model.Film

class UpdateFilmUseCase(private val repository: FilmRepository) {
    suspend operator fun invoke(film: Film) = repository.updateFilm(film)
}
