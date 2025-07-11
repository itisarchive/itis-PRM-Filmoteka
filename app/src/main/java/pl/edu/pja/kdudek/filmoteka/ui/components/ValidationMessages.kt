package pl.edu.pja.kdudek.filmoteka.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.edu.pja.kdudek.filmoteka.domain.model.ValidationError
import pl.edu.pja.kdudek.filmoteka.util.localizeValidationError

@Composable
fun ValidationMessages(errorMessages: List<ValidationError>) {
    Spacer(modifier = Modifier.height(16.dp))
    errorMessages.forEach { message ->
        Text(
            text = localizeValidationError(message),
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
