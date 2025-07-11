@file:OptIn(ExperimentalMaterial3Api::class)

package pl.edu.pja.kdudek.filmoteka.ui.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import pl.edu.pja.kdudek.filmoteka.R
import pl.edu.pja.kdudek.filmoteka.util.formatLocalDate
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId


@Composable
fun DateInput(
    date: LocalDate,
    onDateSelected: (LocalDate) -> Unit
) {
    var openDialog by rememberSaveable { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = formatLocalDate(date),
        onValueChange = {},
        label = { Text(stringResource(R.string.release_date)) },
        readOnly = true,
        trailingIcon = {
            IconButton(onClick = { openDialog = true }) {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = stringResource(R.string.select_date)
                )
            }
        }
    )

    if (openDialog) {
        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = date
                .atStartOfDay(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli()
        )

        DatePickerDialog(
            onDismissRequest = { openDialog = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        val epochMillis = datePickerState.selectedDateMillis
                        if (epochMillis != null) {
                            val selectedLocalDate = Instant
                                .ofEpochMilli(epochMillis)
                                .atZone(ZoneId.systemDefault())
                                .toLocalDate()

                            onDateSelected(selectedLocalDate)
                        }
                        openDialog = false
                    }
                ) {
                    Text(stringResource(R.string.ok))
                }
            },
            dismissButton = {
                TextButton(onClick = { openDialog = false }) {
                    Text(stringResource(R.string.cancel))
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
                showModeToggle = false
            )
        }
    }
}
