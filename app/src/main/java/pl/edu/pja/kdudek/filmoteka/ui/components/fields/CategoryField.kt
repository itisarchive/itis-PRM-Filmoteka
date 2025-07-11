package pl.edu.pja.kdudek.filmoteka.ui.components.fields

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import pl.edu.pja.kdudek.filmoteka.R
import pl.edu.pja.kdudek.filmoteka.domain.model.FilmCategory
import pl.edu.pja.kdudek.filmoteka.util.localizeCategoryName

@Composable
fun ColumnScope.CategoryField(
    category: FilmCategory
) {
    Text(
        text = "${stringResource(R.string.category)}: ${localizeCategoryName(category)}",
        style = MaterialTheme.typography.bodyMedium
    )
}
