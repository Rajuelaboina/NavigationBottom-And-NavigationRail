package com.payment.dashboard.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="userID")
    val userID:Int,
    @ColumnInfo(name="username")
    val username: String,
    @ColumnInfo(name="password")
    val password: String
)