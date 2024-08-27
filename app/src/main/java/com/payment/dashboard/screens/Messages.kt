package com.payment.dashboard.screens



import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults.dateFormatter
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerFormatter
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.payment.dashboard.DateUtils


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Messages() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White/* MaterialTheme.colorScheme.background*/) {
        val dateState = rememberDatePickerState()
        var showDialog by remember { mutableStateOf(false) }
        var showTimeDialog by remember {
            mutableStateOf(false)
        }
        val millisToLocalDate = dateState.selectedDateMillis?.let {
            DateUtils().convertMillisToLocalDate(it)
        }
        val dateToString = millisToLocalDate?.let {
            DateUtils().dateToString(millisToLocalDate) } ?: "Choose Date"
        Column {

            DatePicker(state = dateState,
                title = { Text(text = "Select Date")},
               // headline = { Text(text = "Sample Date")},
                showModeToggle = true,
                dateFormatter = dateFormatter(selectedDateSkeleton = "EE, dd MM, yyyy")
            )
            Text(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                text = dateToString)
            Button(onClick = {
                showDialog = true
            }) {
                   Text(text = "Select date")
            }
            if (showDialog){
                DatePickerDialog(onDismissRequest = { showDialog = false },
                    confirmButton = { 
                        Button(onClick = { showDialog = false }) {
                            Text(text = "Ok")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { showDialog = false }) {
                            Text(text = "Cancel")
                        }
                    }
                ) {
                    DatePicker(state = dateState, showModeToggle = true)
                }
            }

            Button(onClick = {
                showTimeDialog = true},
                border = BorderStroke(2.dp, color = Color.Red),
                contentPadding = ButtonDefaults.ContentPadding
            ) {
                Text(text = "Select Time")
            }

        }
    }
}
// app widget with Glance