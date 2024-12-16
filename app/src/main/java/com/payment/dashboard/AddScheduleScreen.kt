package com.payment.dashboard

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScheduleScreen() {

    val context = LocalContext.current

    val date = remember { Calendar.getInstance().timeInMillis }
    val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = date)
    var showDatePicker by remember { mutableStateOf(false) }

    val timePickerState = rememberTimePickerState()
    var showTimePicker by remember { mutableStateOf(false) }
    var scheduleDate = ""
    var scheduleTime = ""

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        val selectedDate = Calendar.getInstance().apply {
                            timeInMillis = datePickerState.selectedDateMillis!!
                        }
                        scheduleDate = formatter.format(selectedDate.time)
                        showDatePicker = false
                    }
                ) { Text("OK") }
            },
            dismissButton = {
                TextButton( onClick = { showDatePicker = false }
                ) { Text("Cancel") }
            }
        ) { DatePicker(state = datePickerState) }
    }

    if (showTimePicker) {
        TimePickerDialog(
            onDismissRequest = { showTimePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        scheduleTime = "${timePickerState.hour}:${timePickerState.minute}"
                        showTimePicker = false
                    }
                ) { Text("OK") }
            },
            dismissButton = {
                TextButton(
                    onClick = { showTimePicker = false }
                ) { Text("Cancel") }
            }
        ) { TimePicker(state = timePickerState) }
    }
    Column {

    Button(
        onClick = {
            Log.e("DATE<<<<>>>","TIME: "+ timePickerState + datePickerState )
            val scheduleText = "test the app"
            ScheduleNotification().scheduleNotification(context, timePickerState, datePickerState, scheduleText)
        },

        // ...

    ) { Text(text = "Add reminder") }   // Button
    Button(
        onClick = {
            showDatePicker = true
        },

        // ...

    ) { Text(text = "Set Date") }   // Button
    Button(
        onClick = {
            showTimePicker = true
        },

        // ...

    ) { Text(text = "Set Time") }   // Button

    }
}