package ru.elminn.weater_mvvm.di.components

import dagger.Component
import ru.elminn.weater_mvvm.di.module.ViewModelModule
import ru.elminn.weater_mvvm.di.module.DataModule
import ru.elminn.weater_mvvm.di.module.FrameworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, FrameworkModule::class, ViewModelModule::class])
interface AppComponent {

    fun createMainComponent(): MainComponent

}