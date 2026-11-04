package com.example.csc_homework3

import androidx.lifecycle.ViewModel

class AppInfoScreenViewModel(var repository: WorkerRepository = MainApp.workerRepository) : ViewModel()  {

    private var appName = repository.appName
    private var appDeveloperName = repository.appDeveloperName
    private var appVersion = repository.appVersion

    fun getAppName1(): String {
        return appName
    }

    fun getAppDeveloperName(): String {
        return appDeveloperName
    }

    fun getAppVersion(): String {
        return appVersion
    }
}
