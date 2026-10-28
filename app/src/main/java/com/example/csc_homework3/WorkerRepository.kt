package com.example.csc_homework3

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Scanner

    class WorkerRepository(mainApp: Application) {
    var appName by mutableStateOf("Worker App")
    var appDeveloperName by mutableStateOf("Yuvraj Bhira")
    var appVersion by mutableStateOf("1.0")
    val workerList = mutableStateListOf<Worker>()

    init {
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
            try {
                val fis = mainApp.openFileInput("data.txt")
                val scanner = Scanner(fis)
                val tempWorkers = mutableListOf<Worker>()

                while (scanner.hasNextLine()) {
                    val name = scanner.nextLine().trim()
                    if (name.isEmpty()) continue

                    if (scanner.hasNextLine()) {
                        val hours = scanner.nextLine().trim().toDoubleOrNull() ?: 0.0
                        if (scanner.hasNextLine()) {
                            val rate = scanner.nextLine().trim().toDoubleOrNull() ?: 0.0
                            tempWorkers.add(Worker(name, hours, rate))
                        }
                    }
                }
                scanner.close()

                withContext(Dispatchers.Main) {
                    workerList.clear()
                    workerList.addAll(tempWorkers)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
