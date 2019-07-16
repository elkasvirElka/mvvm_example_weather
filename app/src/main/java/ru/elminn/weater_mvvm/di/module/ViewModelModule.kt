package ru.elminn.weater_mvvm.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.elminn.weater_mvvm.di.ViewModelKey
import ru.elminn.weater_mvvm.ui.DayForecastViewModel
import ru.elminn.weater_mvvm.utils.ViewModelFactory
import javax.inject.Singleton

@Module
abstract class ViewModelModule{

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DayForecastViewModel::class)
    abstract fun provideDayForecastViewModel(viewModel: DayForecastViewModel): ViewModel

    //ViewModel without param
    //fun provideDayForecastViewModel(): DayForecastViewModel = DayForecastViewModel()
}