package com.example.rush.mvvm

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "apps")
data class Apps(


    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var appcategory: String,
    var appIcon: Int,
    var appName: String,
    var appLink: String,


    )




