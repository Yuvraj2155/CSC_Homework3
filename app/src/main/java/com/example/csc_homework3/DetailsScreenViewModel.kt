package com.example.csc_homework3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DetailsScreenViewModel(val Workername: String, var workerRepository: WorkerRepository = MainApp.workerRepository): ViewModel(){
    var name by mutableStateOf("")
    var hoursWorked by mutableStateOf(0.0)
    var rate by mutableStateOf(0.0)
    var pay by mutableStateOf(0.0)

    init {
        val worker = workerRepository.getWorkerDetails(Workername)
        name = worker.name
        hoursWorked = worker.hoursWorked
        rate = worker.rate
        pay = hoursWorked * rate
    }

}