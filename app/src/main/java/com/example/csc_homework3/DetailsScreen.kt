package com.example.csc_homework3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DisplayWorkerDetail(name: String, modifier: Modifier = Modifier){
    val viewModel = viewModel { DetailsScreenViewModel(name) }
    val hoursWorked = viewModel.hoursWorked
    val rate = viewModel.rate
    val pay = viewModel.pay


    Surface (
        modifier = modifier.fillMaxWidth().padding(20.dp).wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 50.dp
    ) {
        Column(
            modifier = modifier.fillMaxWidth().padding(10.dp,25.dp),
           verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            DisplayHeading("Detail Screen")
            DisplayNormalText("Name: $name")
            DisplayNormalText("Hours Worked: ${hoursWorked.toString()}")
            DisplayNormalText("Rate: ${rate.toString()}")
            DisplayNormalText("Pay: ${pay.toString()}")
        }

    }

}