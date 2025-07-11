package pl.edu.pja.kdudek.filmoteka.ui.components.fields

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import pl.edu.pja.kdudek.filmoteka.R

@Composable
fun ColumnScope.PosterField(
    posterUri: String?,
) {
    val painter = if (!posterUri.isNullOrEmpty()) {
        rememberAsyncImagePainter(posterUri)
    } else {
        painterResource(R.drawable.poster_placeholder)
    }

    Box(
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .size(250.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = stringResource(R.string.poster),
            modifier = Modifier.fillMaxSize()
        )
    }
}
