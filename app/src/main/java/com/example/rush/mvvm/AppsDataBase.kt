package com.example.rush.mvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Apps::class], version = 1)
abstract class AppsDataBase : RoomDatabase() {

    abstract fun appsDao(): AppsDao

    companion object {
        private var INSTANCE: AppsDataBase? = null
        fun getDatabase(context: Context): AppsDataBase {

            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppsDataBase::class.java,
                        "apps_database"
                    ).createFromAsset("allApps.db")
                        .build()
                }
            }
            return INSTANCE!!

        }
    }
}