package com.example.csc_homework3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Nav(modifier: Modifier = Modifier, navController: NavHostController){
    NavHost(navController = navController, startDestination = "WorkerListScreen", modifier = modifier){
        composable("WorkerListScreen"){
            DisplayWorkList(modifier)
        }
        composable("detailScreen"){
           // AddScreen()
        }
        composable("appInfoScreen"){
            DisplayAppInfo(modifier)
        }
    }

}