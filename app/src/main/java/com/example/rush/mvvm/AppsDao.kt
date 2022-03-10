package com.example.rush.mvvm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query


@Dao
interface AppsDao {

    @Query("SELECT * from apps")
    fun getApps() : LiveData<List<Apps>>
}