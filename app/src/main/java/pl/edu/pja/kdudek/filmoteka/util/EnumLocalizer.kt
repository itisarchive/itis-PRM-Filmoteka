package pl.edu.pja.kdudek.filmoteka.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import pl.edu.pja.kdudek.filmoteka.R
import pl.edu.pja.kdudek.filmoteka.domain.model.FilmCategory
import pl.edu.pja.kdudek.filmoteka.domain.model.ValidationError

@Composable
fun localizeCategoryName(
    category: FilmCategory
): String {
    return when (category) {
        FilmCategory.FILM -> stringResource(R.string.film)
        FilmCategory.SERIES -> stringResource(R.string.series)
        FilmCategory.DOCUMENTARY -> stringResource(R.string.documentary)
    }
}

@Composable
fun localizeValidationError(
    message: ValidationError
): String {
    return when (message) {
        ValidationError.TITLE_BLANK -> stringResource(R.string.error_title)
        ValidationError.RELEASEDATE_TOO_FAR -> stringResource(R.string.error_release_date)
        ValidationError.RATING_MISSING -> stringResource(R.string.error_rating)
    }
}
