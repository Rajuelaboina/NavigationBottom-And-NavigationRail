package com.payment.dashboard

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import kotlin.random.Random

class NotificationHandler (private val context: Context) {
        private val notificationManager = context.getSystemService(NotificationManager::class.java)
        private val notificationChannelID = "Dashboard"

        // SIMPLE NOTIFICATION
        fun showSimpleNotification() {
            val notification = NotificationCompat.Builder(context, notificationChannelID)
                .setContentTitle("Simple Notification")
                .setContentText("Message or text with notification")
                .setSmallIcon(R.drawable.baseline_tv_24)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .setAutoCancel(true)
                .build()  // finalizes the creation

            notificationManager.notify(Random.nextInt(), notification)

    }
}