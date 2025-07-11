package pl.edu.pja.kdudek.filmoteka.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import pl.edu.pja.kdudek.filmoteka.R

@Composable
fun RowScope.MovieCounter(filmCount: Int) {
    Text(
        text = "${stringResource(R.string.movie_count)}: $filmCount",
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier
            .align(Alignment.CenterVertically)
    )
}
