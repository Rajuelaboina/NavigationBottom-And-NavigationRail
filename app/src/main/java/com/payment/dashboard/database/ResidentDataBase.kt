package com.payment.dashboard.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.payment.dashboard.modal.ResidentCompleteSearchItem

@Database(entities = [ResidentCompleteSearchItem::class,UserData::class], version = 1, exportSchema = false)
abstract class ResidentDataBase: RoomDatabase() {
      abstract fun residentDao(): ResidentDao

    companion object{
        var instance: ResidentDataBase?=null

        fun getInstance(context: Context): ResidentDataBase {
            if (instance ==null){
                instance = databaseBuilder(context.applicationContext,
                    ResidentDataBase::class.java,"dashboard")
                    .fallbackToDestructiveMigration().build()
            }
            return instance!!
        }
    }
}