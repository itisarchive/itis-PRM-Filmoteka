package pl.edu.pja.kdudek.filmoteka.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import pl.edu.pja.kdudek.filmoteka.R
import pl.edu.pja.kdudek.filmoteka.domain.model.Film

@Composable
fun DeleteDialog(
    film: Film,
    onDelete: (Film) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(stringResource(R.string.delete_title)) },
        text = { Text("${stringResource(R.string.delete_question)} '${film.title}'?") },
        confirmButton = {
            TextButton(
                onClick = { onDelete(film) }
            ) {
                Text(stringResource(R.string.yes))
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss
            ) {
                Text(stringResource(R.string.no))
            }
        }
    )
}
