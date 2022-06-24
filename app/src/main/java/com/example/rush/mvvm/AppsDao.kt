package com.example.rush.mvvm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface AppsDao {

    @Query("SELECT * from apps")
    fun getApps() : LiveData<List<Apps>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addApps(apps: Apps)

    @Query("DELETE FROM apps Where id=:id")
    fun removeApps(id: Int)
}