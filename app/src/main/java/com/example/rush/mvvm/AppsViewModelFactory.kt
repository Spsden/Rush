package com.example.rush.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AppsViewModelFactory(private val appsRepository: AppsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AppsViewModel(appsRepository) as T
    }
}