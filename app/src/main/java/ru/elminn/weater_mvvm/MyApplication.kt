package ru.elminn.weater_mvvm

import android.app.Application
import android.content.Context
import ru.elminn.weater_mvvm.di.components.AppComponent
import ru.elminn.weater_mvvm.di.components.DaggerAppComponent

class MyApplication :  Application(){

    private lateinit var appComponent: AppComponent
    companion object {
        fun getApp(context: Context?): MyApplication {
            return context?.applicationContext as MyApplication
        }
    }
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()
    }
    fun getAppComponent(): AppComponent = appComponent
}