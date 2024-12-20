@file:OptIn(ExperimentalPermissionsApi::class)

package com.payment.dashboard.screens

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.payment.dashboard.NotificationHandler

@Composable
fun Notifications() {
     val context = LocalContext.current
    // Notification manager
    val postNotificationPermission = rememberPermissionState(permission = Manifest.permission.POST_NOTIFICATIONS)
    val notificationHandler = NotificationHandler(context)

    LaunchedEffect(key1 = true) {
        if (!postNotificationPermission.status.isGranted) {
            postNotificationPermission.launchPermissionRequest()
        }
    }

    Column {
        Button(onClick = {
            notificationHandler.showSimpleNotification()
        }) { Text(text = "Simple notification") }
    }
}