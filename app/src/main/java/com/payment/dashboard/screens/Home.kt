package com.payment.dashboard.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Home(bb: Boolean) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
              Column {
                  Text(text = "Home Screen")
              }
    }
}
/*
@Preview
@Composable
fun GreetingSecondPreview(){
    Home()
}*/
