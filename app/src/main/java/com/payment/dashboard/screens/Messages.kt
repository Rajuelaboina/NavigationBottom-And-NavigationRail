package com.payment.dashboard.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Messages() {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White/* MaterialTheme.colorScheme.background*/) {
        Column {
            Text(text = "MSG Screen")
        }
    }
}