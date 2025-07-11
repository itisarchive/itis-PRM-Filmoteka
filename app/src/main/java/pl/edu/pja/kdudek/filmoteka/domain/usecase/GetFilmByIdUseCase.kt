package pl.edu.pja.kdudek.filmoteka.domain.usecase

import pl.edu.pja.kdudek.filmoteka.data.repository.FilmRepository
import pl.edu.pja.kdudek.filmoteka.domain.model.Film

class GetFilmByIdUseCase(private val repository: FilmRepository) {
    suspend operator fun invoke(id: Long): Film? = repository.getFilmById(id)
}
