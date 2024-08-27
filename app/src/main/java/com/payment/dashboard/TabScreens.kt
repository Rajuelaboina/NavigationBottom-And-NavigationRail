package com.payment.dashboard

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.payment.dashboard.database.ResidentDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MessageScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Column {
        CenterText(text = "Message")
        scope.launch(Dispatchers.IO) {
            val list =  ResidentDataBase.getInstance(context).residentDao().getAllUsers()
            Log.e("my data","list:"+ list)
        }

    }
    // 50
}
@Composable
fun GroupScreen() {
    CenterText(text = "Group")
}
@Composable
fun HomeScreen() {
    CenterText(text = "Home")
}

@Composable
fun NotificationScreen() {
    CenterText(text = "History")
}

@Composable
fun ProfileScreen() {
    CenterText(text = "Profile")
}

@Composable
fun CenterText(text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, fontSize = 32.sp)
    }
}