package pl.edu.pja.kdudek.filmoteka.ui.components.buttons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import pl.edu.pja.kdudek.filmoteka.R
import pl.edu.pja.kdudek.filmoteka.domain.model.FilmCategory
import pl.edu.pja.kdudek.filmoteka.util.localizeCategoryName

@Composable
fun FilterButton(
    selectedCategory: FilmCategory?,
    selectedWatched: Boolean?,
    onCategorySelected: (FilmCategory?) -> Unit,
    onWatchedSelected: (Boolean?) -> Unit
) {
    var menuExpanded by remember { mutableStateOf(false) }
    val categoryText = when (selectedCategory) {
        null -> ""
        else -> localizeCategoryName(selectedCategory)
    }
    val watchedText = when (selectedWatched) {
        null -> ""
        true -> stringResource(R.string.watched)
        false -> stringResource(R.string.not_watched)
    }
    val activeFilters = listOf(categoryText, watchedText).filter { it.isNotEmpty() }
    val activeFiltersText = if (activeFilters.isEmpty()) "" else activeFilters.joinToString()

    FilledTonalButton(
        onClick = { menuExpanded = true }
    ) {
        Icon(
            imageVector = Icons.Default.FilterList,
            contentDescription = stringResource(R.string.filter)
        )
        if (activeFiltersText.isNotEmpty()) {
            Spacer(Modifier.width(8.dp))
            Text(text = activeFiltersText)
        }
    }

    DropdownMenu(
        expanded = menuExpanded,
        onDismissRequest = { menuExpanded = false }
    ) {
        Text(
            stringResource(R.string.category),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp)
        )
        CategoryMenuItems(
            onCategorySelected = onCategorySelected,
            onClose = { menuExpanded = false }
        )

        HorizontalDivider()

        Text(
            stringResource(R.string.status),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp)
        )
        WatchedMenuItems(
            onWatchedSelected = onWatchedSelected,
            onClose = { menuExpanded = false }
        )
    }
}

@Composable
private fun CategoryMenuItems(
    onCategorySelected: (FilmCategory?) -> Unit,
    onClose: () -> Unit
) {
    DropdownMenuItem(
        text = { Text(stringResource(R.string.all)) },
        onClick = {
            onCategorySelected(null)
            onClose()
        }
    )
    FilmCategory.entries.forEach { cat ->
        val label = localizeCategoryName(cat)
        DropdownMenuItem(
            text = { Text(label) },
            onClick = {
                onCategorySelected(cat)
                onClose()
            }
        )
    }
}

@Composable
private fun WatchedMenuItems(
    onWatchedSelected: (Boolean?) -> Unit,
    onClose: () -> Unit
) {
    DropdownMenuItem(
        text = { Text(stringResource(R.string.all)) },
        onClick = {
            onWatchedSelected(null)
            onClose()
        }
    )
    DropdownMenuItem(
        text = { Text(stringResource(R.string.watched)) },
        onClick = {
            onWatchedSelected(true)
            onClose()
        }
    )
    DropdownMenuItem(
        text = { Text(stringResource(R.string.not_watched)) },
        onClick = {
            onWatchedSelected(false)
            onClose()
        }
    )
}
