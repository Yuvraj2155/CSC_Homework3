package com.example.csc_homework3

import androidx.lifecycle.ViewModel

class WorkerListScreenViewModel(var workerRepository: WorkerRepository = MainApp.workerRepository) : ViewModel() {

    var WorkerList = workerRepository.workerList
        private set

    fun getWorkerList(): List<Worker> {
        return WorkerList
    }

    fun addWorker(worker: Worker) {
        WorkerList.add(worker)
    }


}
