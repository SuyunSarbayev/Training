package suyun.example.training.di

import android.app.Application
import org.koin.android.ext.koin.androidContext

fun initializeKoin(context: Application){
   org.koin.core.context.startKoin {
        androidContext(context)
        modules(listOf(
            applicationModule,
            viewModelModule,
            repositoryModule
        ))
    }
}