package com.example.rush.mvvm

import androidx.lifecycle.LiveData

class AppsRepository(private val appsDao: AppsDao) {

    fun getApps() : LiveData<List<Apps>>{
        return appsDao.getApps()
    }

    suspend fun addApps(apps: Apps) {
        appsDao.addApps(apps)
    }

    fun removeApps(id:Int){
        appsDao.removeApps(id)
    }
}