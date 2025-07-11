package pl.edu.pja.kdudek.filmoteka.ui.components.fields

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pl.edu.pja.kdudek.filmoteka.R
import pl.edu.pja.kdudek.filmoteka.ui.theme.DarkGreen
import pl.edu.pja.kdudek.filmoteka.ui.theme.DarkRed

@Composable
fun ColumnScope.StatusField(
    isWatched: Boolean
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (isWatched) {
            Text(
                text = stringResource(R.string.watched),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = DarkGreen,
                modifier = Modifier.size(20.dp)
            )
        } else {
            Text(
                text = stringResource(R.string.not_watched),
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                tint = DarkRed,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
