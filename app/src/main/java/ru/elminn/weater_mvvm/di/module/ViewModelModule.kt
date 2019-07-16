package ru.elminn.weater_mvvm.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.elminn.weater_mvvm.data.repository.weather.WeatherRepository
import ru.elminn.weater_mvvm.di.ViewModelKey
import ru.elminn.weater_mvvm.ui.DayForecastViewModel
import javax.inject.Singleton
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule{

    @Singleton
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DayForecastViewModel::class)
    //fun provideMainActivityViewModel(): DayForecastViewModel = DayForecastViewModel()
    abstract fun provideMainActivityViewModel(viewModel: DayForecastViewModel): ViewModel
}