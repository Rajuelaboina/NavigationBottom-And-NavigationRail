package com.payment.dashboard

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ReminderReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val scheduleNotificationService = context?.let { ReminderNotification(it) }
        val title: String? = intent?.getStringExtra("RMNDR_NOTI_TITLE_KEY")
        scheduleNotificationService?.sendReminderNotification(title)
    }
}
