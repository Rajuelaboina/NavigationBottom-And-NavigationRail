package com.payment.dashboard.screens

import android.icu.util.Calendar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Emails() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White/*MaterialTheme.colorScheme.onPrimary*/) {
        var sheetState = rememberModalBottomSheetState()
        val scope = rememberCoroutineScope()
        var showBottomSheet by remember { mutableStateOf(false) }

        Column(modifier = Modifier.fillMaxSize())
        {
            val isChecked = remember { mutableStateOf(false) }
            Row {
                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = {
                        isChecked.value = it
                        showBottomSheet =true
                                      },
                    enabled = true
                )
                Text(
                    text = "Checkbox",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )




            } // first column
            /*BadgedBox(badge = {
                Badge(
                    modifier = Modifier.shadow(elevation = 2.dp, shape = RoundedCornerShape(32.dp)),
                    contentColor = Color.Red,
                    backgroundColor = Color.White
                ){
                    Text(text = "100", fontSize = 10.sp, color = Color.Red)
                }
            }) {
                Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Email" )

            }*/

            if (showBottomSheet){
                ModalBottomSheet(
                    onDismissRequest =
                    { showBottomSheet = false
                      sheetState = sheetState}
                ) {
                   Button(onClick = {
                       scope.launch {
                           sheetState .hide()
                       }.invokeOnCompletion {
                           if (!sheetState.isVisible){
                               showBottomSheet = false
                           }
                       }
                   }) {

                           Text("Hide bottom sheet")

                   }
                }
            }

            DialExample(
                onDismiss = {
                    showBottomSheet = false
                },
                onConfirm ={

                },
            )


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialExample(
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {
    val currentTime = Calendar.getInstance()
    val pickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )
 Column {
     TimePicker(state = pickerState)
     Button(onClick = onDismiss) {
         Text(text = "Dismiss Picker")
     }
     Button(onClick = onConfirm) {
         Text(text = "Confirm Selection")
     }
 }

}
