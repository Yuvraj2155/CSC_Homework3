package com.example.csc_homework3

import android.app.Application

class MainApp: Application() {
    companion object {
        lateinit var workerRepository: WorkerRepository
    }
    override fun onCreate() {
        super.onCreate()
        workerRepository = WorkerRepository()
    }
}
