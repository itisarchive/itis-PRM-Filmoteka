package pl.edu.pja.kdudek.filmoteka.ui.components.fields

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pl.edu.pja.kdudek.filmoteka.R

@Composable
fun ColumnScope.CommentField(
    comment: String?
) {
    if (!comment.isNullOrBlank()) {
        Text(
            text = "${stringResource(R.string.comment)}:",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = comment,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
