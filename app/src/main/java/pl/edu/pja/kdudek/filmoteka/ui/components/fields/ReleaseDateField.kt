package pl.edu.pja.kdudek.filmoteka.ui.components.fields

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import pl.edu.pja.kdudek.filmoteka.util.formatLocalDate
import java.time.LocalDate

@Composable
fun ColumnScope.ReleaseDateField(
    releaseDate: LocalDate
) {
    Text(
        text = formatLocalDate(releaseDate),
        style = MaterialTheme.typography.bodyMedium.copy(
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    )
}
