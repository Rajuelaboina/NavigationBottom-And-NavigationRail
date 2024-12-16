package com.payment.dashboard

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import java.util.Calendar

class ScheduleNotification {
    @OptIn(ExperimentalMaterial3Api::class)
    fun scheduleNotification(
        context: Context,
        timePickerState: TimePickerState,
        datePickerState: DatePickerState,
        title: String
    ) {
        val intent = Intent(context.applicationContext, ReminderReceiver::class.java)

        intent.putExtra("RMNDR_NOTI_TITLE_KEY", title)
        val RMNDR_NOTI_ID = 100
        val pendingIntent = PendingIntent.getBroadcast(
            context.applicationContext,
            RMNDR_NOTI_ID,
            intent,
            PendingIntent.FLAG_MUTABLE
        )

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val selectedDate = Calendar.getInstance().apply {
            timeInMillis = datePickerState.selectedDateMillis!!

        }

        val year = selectedDate.get(Calendar.YEAR)
        val month = selectedDate.get(Calendar.MONTH)+1
        val day = selectedDate.get(Calendar.DAY_OF_MONTH)
        Log.e("DATE<<<<>>>","year: "+ year)
        Log.e("DATE<<<<>>>","month: "+ month)
        Log.e("DATE<<<<>>>","day: "+ day)
        Log.e("DATE<<<<>>>","HOUR: "+ timePickerState.hour)
        Log.e("DATE<<<<>>>","MINUTE: "+ timePickerState.minute)

        val calendar = Calendar.getInstance()
       // calendar.set(year, month, day, timePickerState.hour, timePickerState.minute)

        calendar.set(Calendar.HOUR_OF_DAY,timePickerState.hour)
        calendar.set(Calendar.MINUTE,timePickerState.minute)
        calendar.set(Calendar.SECOND,10)
        calendar.set(Calendar.MILLISECOND, 0)
        calendar.set(Calendar.AM_PM, Calendar.PM)

        /*alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            pendingIntent
        )*/
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,AlarmManager.INTERVAL_DAY,pendingIntent)


        Toast.makeText(context, "Reminder set!!", Toast.LENGTH_SHORT).show()
    }
}
/*https://admission.tulane.edu/meet-us
https://apply.tulane.edu/register/?id=95fb4083-e896-4288-af18-f4f77937e3d6
https://admission.tulane.edu/international/global-ambassadors
https://tulane.welcometocollege.com/
https://tulane.welcometocollege.com/diversity-fellows

https://tulane.welcometocollege.com/spring-scholar-ambassadors
https://tulane.edu/search-results?q=residency*/
// https://medicine.tulane.edu/medical-resident/otolaryngology