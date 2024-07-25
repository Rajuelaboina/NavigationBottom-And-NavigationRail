package com.payment.dashboard.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun News() {
    Column {
        Text(text = "This is news screen", Modifier.align(alignment = Alignment.CenterHorizontally))
    }
}