package com.example.rush.mvvm

import androidx.lifecycle.LiveData

class AppsRepository(private val appsDao: AppsDao) {

    fun getApps() : LiveData<List<Apps>>{
        return appsDao.getApps()
    }
}