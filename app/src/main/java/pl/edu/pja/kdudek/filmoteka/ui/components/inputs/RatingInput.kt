package pl.edu.pja.kdudek.filmoteka.ui.components.inputs

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.StarHalf
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pl.edu.pja.kdudek.filmoteka.R
import pl.edu.pja.kdudek.filmoteka.ui.theme.Orange
import kotlin.math.roundToInt

@Composable
fun RatingInput(
    rating: Int,
    onRatingChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    maxStars: Int = 5
) {
    var containerWidth by remember { mutableIntStateOf(0) }

    Box(
        modifier = modifier
            .onSizeChanged { containerWidth = it.width }
            .pointerInput(Unit) {
                detectDragGestures(
                    onDragStart = { offset ->
                        onRatingChange(offset.toRating(containerWidth, maxStars))
                    },
                    onDrag = { change, _ ->
                        onRatingChange(change.position.toRating(containerWidth, maxStars))
                    }
                )
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = { offset ->
                        onRatingChange(offset.toRating(containerWidth, maxStars))
                    }
                )
            }
    ) {
        Row {
            for (i in 1..maxStars) {
                val starIcon = starIconForIndex(rating, i)
                val tintColor =
                    if (starIcon == Icons.Filled.StarBorder) MaterialTheme.colorScheme.onSurfaceVariant else Orange

                Icon(
                    imageVector = starIcon,
                    contentDescription = "${stringResource(R.string.star)} $i",
                    tint = tintColor,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

private fun starIconForIndex(rating: Int, starIndex: Int) = when {
    rating >= starIndex * 2 -> Icons.Filled.Star
    rating >= starIndex * 2 - 1 -> Icons.AutoMirrored.Filled.StarHalf
    else -> Icons.Filled.StarBorder
}

private fun Offset.toRating(containerWidth: Int, maxStars: Int): Int {
    if (containerWidth == 0) return 0
    val fraction = (x / containerWidth).coerceIn(0f, 1f)
    val rawStars = fraction * maxStars * 2
    return rawStars.roundToInt().coerceIn(0, maxStars * 2)
}
