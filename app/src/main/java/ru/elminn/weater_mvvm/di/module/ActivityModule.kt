package ru.elminn.weater_mvvm.di.module

import dagger.Module
import dagger.Provides
import ru.elminn.weater_mvvm.data.repository.weather.WeatherRepository
import ru.elminn.weater_mvvm.ui.DayForecastViewModel


@Module
class ActivityModule{
    @Provides
    //fun provideMainActivityViewModel(): DayForecastViewModel = DayForecastViewModel()
    fun provideMainActivityViewModel(weaterRepository: WeatherRepository): DayForecastViewModel = DayForecastViewModel(weaterRepository)
}