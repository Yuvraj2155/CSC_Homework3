package com.example.csc_homework3

import androidx.lifecycle.ViewModel

class AppInfoScreenViewModel(var repository: WorkerRepository = MainApp.workerRepository, var targetWorkerName: String = "") : ViewModel()  {
}