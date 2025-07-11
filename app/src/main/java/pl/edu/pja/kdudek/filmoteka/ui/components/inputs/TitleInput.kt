package pl.edu.pja.kdudek.filmoteka.ui.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import pl.edu.pja.kdudek.filmoteka.R

@Composable
fun TitleInput(
    title: String,
    onTitleChange: (String) -> Unit
) {
    OutlinedTextField(
        value = title,
        onValueChange = { newTitle -> onTitleChange(newTitle) },
        label = { Text(stringResource(R.string.title)) },
        modifier = Modifier.fillMaxWidth()
    )
}
