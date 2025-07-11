package pl.edu.pja.kdudek.filmoteka.ui.components.inputs

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import pl.edu.pja.kdudek.filmoteka.R

@Composable
fun ColumnScope.ImageInput(
    posterUri: String,
    onPosterUriChange: (String) -> Unit = {}

) {
    val context = LocalContext.current
    val imagePickerLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        uri?.let {
            val flags =
                Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
            try {
                context.contentResolver.takePersistableUriPermission(it, flags)
            } catch (e: SecurityException) {
                e.printStackTrace()
            }
            onPosterUriChange(it.toString())
        }
    }

    Box(
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .size(200.dp)
            .clickable {
                imagePickerLauncher.launch(arrayOf("image/*"))
            }
    ) {
        val painter = if (posterUri.isNotEmpty()) {
            rememberAsyncImagePainter(posterUri)
        } else {
            painterResource(R.drawable.poster_placeholder_editable)
        }
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}
