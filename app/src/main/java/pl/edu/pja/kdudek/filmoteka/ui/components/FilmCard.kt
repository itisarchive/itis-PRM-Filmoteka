@file:OptIn(ExperimentalFoundationApi::class)

package pl.edu.pja.kdudek.filmoteka.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import pl.edu.pja.kdudek.filmoteka.R
import pl.edu.pja.kdudek.filmoteka.domain.model.Film
import pl.edu.pja.kdudek.filmoteka.ui.components.fields.RatingField
import pl.edu.pja.kdudek.filmoteka.util.formatLocalDate
import pl.edu.pja.kdudek.filmoteka.util.localizeCategoryName

@Composable
fun FilmCard(
    film: Film,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .combinedClickable(
                onClick = { onClick() },
                onLongClick = { onLongClick() }
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .padding(8.dp),
                verticalAlignment = CenterVertically
            ) {
                val painter = if (!film.posterUri.isNullOrEmpty()) {
                    rememberAsyncImagePainter(film.posterUri)
                } else {
                    painterResource(R.drawable.poster_placeholder)
                }
                Box(
                    modifier = Modifier
                        .size(64.dp)
                ) {
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Column {
                    Text(
                        text = film.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = formatLocalDate(film.releaseDate),
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    )

                    Text(
                        text = localizeCategoryName(film.category),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            if (film.isWatched) {
                RatingField(
                    rating = film.rating,
                    heading = false,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .scale(0.8f)
                        .padding(0.dp, 0.dp, 0.dp, 2.dp)
                )
            } else {
                Text(
                    text = stringResource(R.string.not_watched),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(0.dp, 0.dp, 16.dp, 4.dp)
                )
            }
        }
    }
}
