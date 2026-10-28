package com.example.csc_homework3

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CardwithText(name: String, hoursWorked: Double, rate: Double) {
    Card(){
        Text(name)
        Text(hoursWorked.toString())
        Text(rate.toString())
    }
}

@Composable
fun DisplayWorkList(modifier: Modifier){
    val viewModel = viewModel {WorkerListScreenViewModel()}
    LazyColumn(modifier = modifier){
        items(viewModel.getWorkerList()){ worker ->
            CardwithText(worker.name, worker.hoursWorked, worker.rate)
        }


    }
}