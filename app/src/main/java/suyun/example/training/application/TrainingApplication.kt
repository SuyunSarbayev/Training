package suyun.example.training.application

import android.app.Application
import suyun.example.training.di.initializeKoin

class TrainingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeKoin(this)
    }
}