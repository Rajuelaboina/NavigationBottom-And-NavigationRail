package com.payment.dashboard.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.payment.dashboard.modal.ResidentCompleteSearchItem

@Dao
interface ResidentDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
      fun insertResident(residentCompleteSearchItem: ResidentCompleteSearchItem)

   @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun loginInsert(userData: UserData)

   @Query("SELECT * FROM user_table")
     fun getAllUsers():List<UserData>

     @Query("SELECT * FROM resident")
     fun getAllResidents(): List<ResidentCompleteSearchItem>
}