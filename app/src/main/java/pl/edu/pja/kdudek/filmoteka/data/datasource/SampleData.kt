package pl.edu.pja.kdudek.filmoteka.data.datasource

import pl.edu.pja.kdudek.filmoteka.data.db.FilmEntity
import pl.edu.pja.kdudek.filmoteka.domain.model.FilmCategory
import java.time.LocalDate

object SampleData {
    val exampleFilms = listOf(
        FilmEntity(
            title = "Shawshank Redemption",
            releaseDate = LocalDate.of(1994, 9, 23),
            category = FilmCategory.FILM,
            isWatched = false,
            rating = null,
            comment = null,
            posterUri = null
        ),
        FilmEntity(
            title = "Friends",
            releaseDate = LocalDate.of(1994, 9, 22),
            category = FilmCategory.SERIES,
            isWatched = true,
            rating = 8,
            comment = "Bardzo ciekawy serial",
            posterUri = null
        ),
        FilmEntity(
            title = "Inception",
            releaseDate = LocalDate.of(2010, 7, 16),
            category = FilmCategory.FILM,
            isWatched = true,
            rating = 9,
            comment = "Świetny film",
            posterUri = null
        ),
        FilmEntity(
            title = "Planet Earth",
            releaseDate = LocalDate.of(2006, 3, 5),
            category = FilmCategory.DOCUMENTARY,
            isWatched = false,
            rating = null,
            comment = null,
            posterUri = null
        ),
        FilmEntity(
            title = "Breaking Bad",
            releaseDate = LocalDate.of(2008, 1, 20),
            category = FilmCategory.SERIES,
            isWatched = true,
            rating = 10,
            comment = "Najlepszy serial wszech czasów",
            posterUri = null
        ),
        FilmEntity(
            title = "The Godfather",
            releaseDate = LocalDate.of(1972, 3, 24),
            category = FilmCategory.FILM,
            isWatched = true,
            rating = 10,
            comment = "Kultowy film",
            posterUri = null
        ),
        FilmEntity(
            title = "The Office",
            releaseDate = LocalDate.of(2005, 3, 24),
            category = FilmCategory.SERIES,
            isWatched = true,
            rating = 8,
            comment = "Świetny serial komediowy",
            posterUri = null
        ),
        FilmEntity(
            title = "The Dark Knight",
            releaseDate = LocalDate.of(2008, 7, 18),
            category = FilmCategory.FILM,
            isWatched = true,
            rating = 9,
            comment = "Najlepszy film o Batmanie",
            posterUri = null
        ),
        FilmEntity(
            title = "The Crown",
            releaseDate = LocalDate.of(2016, 11, 4),
            category = FilmCategory.SERIES,
            isWatched = false,
            rating = null,
            comment = null,
            posterUri = null
        ),
        FilmEntity(
            title = "The Social Dilemma",
            releaseDate = LocalDate.of(2020, 1, 26),
            category = FilmCategory.DOCUMENTARY,
            isWatched = true,
            rating = 4,
            comment = "Ciekawy dokument o mediach społecznościowych",
            posterUri = null
        ),
        FilmEntity(
            title = "The Matrix",
            releaseDate = LocalDate.of(1999, 3, 31),
            category = FilmCategory.FILM,
            isWatched = true,
            rating = 5,
            comment = "Kultowy film sci-fi",
            posterUri = null
        ),
        FilmEntity(
            title = "Planet Earth II",
            releaseDate = LocalDate.of(2016, 2, 28),
            category = FilmCategory.DOCUMENTARY,
            isWatched = false,
            rating = null,
            comment = null,
            posterUri = null
        ),
        FilmEntity(
            title = "Stranger Things",
            releaseDate = LocalDate.of(2016, 7, 15),
            category = FilmCategory.SERIES,
            isWatched = true,
            rating = 7,
            comment = "Ciekawy serial sci-fi",
            posterUri = null
        )
    )
}
