package com.example.csc_homework3

import androidx.lifecycle.ViewModel

class WorkerListScreenViewModel(var workerRepository: WorkerRepository = MainApp.workerRepository) : ViewModel() {

    var workerList = workerRepository.workerList

}
