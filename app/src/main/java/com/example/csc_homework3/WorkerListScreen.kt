package com.example.csc_homework3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

@Composable
fun CardWithText(name: String, hoursWorked: Double, rate: Double, modifier: Modifier = Modifier, navController: NavHostController) {

    Card(
        modifier = modifier.fillMaxWidth().clickable {
            navController.navigate("detailScreen/$name")
        },
        shape = RoundedCornerShape(10.dp)

    ) {
        Column(
            modifier = modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            DisplayTitle(name)
            DisplayNormalText("Hours Worked: $hoursWorked")
            DisplayNormalText("Rate: $$rate")
        }
    }
}

@Composable
fun DisplayWorkList( modifier: Modifier = Modifier, navController: NavHostController) {
    val viewModel = viewModel { WorkerListScreenViewModel() }


    Surface (
        modifier = modifier.fillMaxWidth().padding(20.dp) ,
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 50.dp
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(5.dp),
            verticalArrangement = Arrangement.spacedBy(3.dp))
        {
            DisplayHeading("Worker List")
            LazyColumn() {
                items(viewModel.getWorkerList()) { worker ->
                    CardWithText(
                        name = worker.name,
                        hoursWorked = worker.hoursWorked,
                        rate = worker.rate,
                        modifier = Modifier.padding(bottom = 8.dp),
                        navController = navController
                    )
                }
            }
        }
    }
}