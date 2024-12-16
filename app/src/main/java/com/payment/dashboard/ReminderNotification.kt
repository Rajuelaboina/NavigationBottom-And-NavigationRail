package com.payment.dashboard

import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat

class ReminderNotification (private val context: Context) {

    private val notificationManager = context.getSystemService(NotificationManager::class.java)

    fun sendReminderNotification(title: String?) {
        val notification = NotificationCompat.Builder(context, "RMNDR_NOTI_CHNNL_ID")
            .setContentText(context.getString(R.string.app_name))
            .setContentTitle(title)
            .setSmallIcon(R.drawable.doctor)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    context.resources,
                    R.drawable.baseline_email_24
                )
            )
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("It's time for $title")
            )
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(context.bitmapFromResource(R.drawable.img))
            )
            .setAutoCancel(true)
            .build()

        notificationManager.notify(100, notification)
    }

    private fun Context.bitmapFromResource(
        @DrawableRes resId: Int
    ) = BitmapFactory.decodeResource(
        resources,
        resId
    )
}