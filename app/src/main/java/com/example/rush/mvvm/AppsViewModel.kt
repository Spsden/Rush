package com.example.rush.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class AppsViewModel(private val appsRepository: AppsRepository) : ViewModel() {

    fun getApps() : LiveData<List<Apps>>{
        return appsRepository.getApps()
    }

    suspend fun addApps(apps: Apps){
        appsRepository.addApps(apps)
    }

    fun removeApps(id:Int){
        appsRepository.removeApps(id)
    }
}