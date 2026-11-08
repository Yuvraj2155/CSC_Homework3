package com.example.csc_homework3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AppInfoScreenViewModel(var repository: WorkerRepository = MainApp.workerRepository) : ViewModel() {

    var appName by mutableStateOf(repository.appName)
    var appDeveloperName by mutableStateOf(repository.appDeveloperName)
    var appVersion by mutableStateOf(repository.appVersion)

}


