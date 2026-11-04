package com.example.csc_homework3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun DisplayAppInfo(modifier: Modifier){
    Surface(modifier) {
        val viewModel = viewModel { AppInfoScreenViewModel() }
        Column {
            Text(text = "App Info Screen")
            Text(text = "App Name: ${viewModel.getAppName1()}")
            Text(text = "App Developer: ${viewModel.getAppDeveloperName()}")
            Text(text = "App Version: ${viewModel.getAppVersion()}")
        }

    }
}