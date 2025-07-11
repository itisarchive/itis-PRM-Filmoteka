package pl.edu.pja.kdudek.filmoteka.domain.usecase

import pl.edu.pja.kdudek.filmoteka.domain.model.Film
import pl.edu.pja.kdudek.filmoteka.domain.model.ValidationError
import pl.edu.pja.kdudek.filmoteka.domain.model.ValidationError.RATING_MISSING
import pl.edu.pja.kdudek.filmoteka.domain.model.ValidationError.RELEASEDATE_TOO_FAR
import pl.edu.pja.kdudek.filmoteka.domain.model.ValidationError.TITLE_BLANK
import pl.edu.pja.kdudek.filmoteka.domain.model.ValidationResult
import java.time.LocalDate

class ValidateFilmUseCase {
    operator fun invoke(film: Film): ValidationResult {
        var isValid = true
        val errorMessages = mutableListOf<ValidationError>()
        if (film.title.isBlank()) {
            isValid = false
            errorMessages.add(TITLE_BLANK)
        }
        if (film.releaseDate.isAfter(LocalDate.now().plusYears(2))) {
            isValid = false
            errorMessages.add(RELEASEDATE_TOO_FAR)
        }
        if (film.isWatched && film.rating == null) {
            isValid = false
            errorMessages.add(RATING_MISSING)
        }
        return ValidationResult(isSuccessful = isValid, errorMessages = errorMessages)
    }
}
