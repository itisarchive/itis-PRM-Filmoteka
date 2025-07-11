package pl.edu.pja.kdudek.filmoteka.ui.components.inputs

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import pl.edu.pja.kdudek.filmoteka.R

@Composable
fun StatusInput(
    status: Boolean,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = status,
            onCheckedChange = { newStatus -> onCheckedChange(newStatus) },
        )
        Text(text = stringResource(R.string.watched))
    }
}
