package pl.edu.pja.kdudek.filmoteka.ui.components.fields

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import pl.edu.pja.kdudek.filmoteka.R
import pl.edu.pja.kdudek.filmoteka.ui.components.inputs.RatingInput

@Composable
fun RatingField(
    rating: Int?,
    modifier: Modifier = Modifier,
    heading: Boolean = true,
) {
    if (heading) {
        Text(
            text = "${stringResource(R.string.rating)}:",
            style = MaterialTheme.typography.titleMedium
        )
    }
    RatingInput(
        rating = rating ?: 0,
        onRatingChange = {},
        modifier = modifier
            .alpha(0.5f)
    )
}
