package pl.edu.pja.kdudek.filmoteka.ui.components.fields

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ColumnScope.TitleField(
    title: String
) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall
    )
}
