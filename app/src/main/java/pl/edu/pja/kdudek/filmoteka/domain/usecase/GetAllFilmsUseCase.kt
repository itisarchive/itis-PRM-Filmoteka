package pl.edu.pja.kdudek.filmoteka.domain.usecase

import kotlinx.coroutines.flow.Flow
import pl.edu.pja.kdudek.filmoteka.data.repository.FilmRepository
import pl.edu.pja.kdudek.filmoteka.domain.model.Film

class GetAllFilmsUseCase(private val repository: FilmRepository) {
    operator fun invoke(): Flow<List<Film>> {
        return repository.getAllFilms()
    }
}
