package com.example.csc_homework3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.csc_homework3.ui.theme.CSC_Homework3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // defining the list of navigation items
            val navItemsList = listOf(
                MyNavItem(
                    title="WorkerList",
                    iconSelected = Icons.Filled.Home,
                    iconUnselected = Icons.Outlined.Home,
                    route="workerListScreen"
                ),
                MyNavItem(title="AppInfo",
                    iconSelected = Icons.Filled.Add,
                    iconUnselected = Icons.Outlined.Add,
                    route="appInfoScreen"
                )
            )
            val navHostController = rememberNavController()
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            CSC_Homework3Theme {
                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            navItemsList.forEach { item ->
                                val isSelected = currentDestination?.hierarchy?.any { it.route.equals(item.route) } == true
                                NavigationBarItem(
                                    selected = isSelected,
                                    onClick = {
                                        navHostController.navigate(item.route) {
                                            launchSingleTop = true
                                            restoreState = true
                                            popUpTo(navHostController.graph.findStartDestination().id) { saveState = true }
                                        }
                                    },
                                    label = { Text(text = item.title) },
                                    icon = {
                                        Icon(contentDescription = item.title,
                                            imageVector = if (isSelected) item.iconSelected else item.iconUnselected
                                        ) // end - Icon
                                    } // end - icon
                                ) // end – NavigationBarItem
                            } // end – forEach
                        } // end - NavigationBar
                        }
                    ,modifier = Modifier.fillMaxSize(), ) { innerPadding ->
                    Nav(
                        modifier = Modifier.padding(innerPadding),
                        navController = navHostController
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CSC_Homework3Theme {
        Greeting("Android")
    }
}