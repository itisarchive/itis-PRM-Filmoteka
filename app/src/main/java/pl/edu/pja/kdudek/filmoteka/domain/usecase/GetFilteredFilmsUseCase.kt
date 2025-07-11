package pl.edu.pja.kdudek.filmoteka.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import pl.edu.pja.kdudek.filmoteka.data.repository.FilmRepository
import pl.edu.pja.kdudek.filmoteka.domain.model.Film
import pl.edu.pja.kdudek.filmoteka.domain.model.FilmFilter

class GetFilteredFilmsUseCase(private val repository: FilmRepository) {
    operator fun invoke(filter: FilmFilter): Flow<List<Film>> {
        return repository.getAllFilms().map { films ->
            films.filter { film ->
                (filter.category == null || film.category == filter.category) &&
                        (filter.isWatched == null || film.isWatched == filter.isWatched)
            }
        }
    }
}
