package com.example.csc_homework3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun DisplayAppInfo(modifier: Modifier = Modifier){
    Surface (
        modifier = modifier.fillMaxWidth().padding(20.dp).wrapContentHeight(),
        shape = RoundedCornerShape(10.dp),
        shadowElevation = 50.dp
    ) {
        val viewModel = viewModel { AppInfoScreenViewModel() }
        Column (
            modifier = modifier.fillMaxWidth().padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            DisplayHeading("App Info")
            DisplayNormalText("Name: ${viewModel.getAppName()}")
            DisplayNormalText("Developer: ${viewModel.getAppDeveloperName()}")
            DisplayNormalText("Version: ${viewModel.getAppVersion()}")
        }

    }
}