package pl.edu.pja.kdudek.filmoteka.ui.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import pl.edu.pja.kdudek.filmoteka.R

@Composable
fun CommentInput(
    comment: String,
    onCommentChange: (String) -> Unit
) {
    OutlinedTextField(
        value = comment,
        onValueChange = { newComment -> onCommentChange(newComment) },
        label = { Text(stringResource(R.string.comment)) },
        modifier = Modifier.fillMaxWidth(),
        maxLines = 5
    )
}
