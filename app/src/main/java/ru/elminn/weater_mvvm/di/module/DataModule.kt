package ru.elminn.weater_mvvm.di.module

import dagger.Module
import dagger.Provides
import ru.elminn.weater_mvvm.data.network.clients.RxWeatherClient
import ru.elminn.weater_mvvm.data.repository.weather.WeatherRepository
import ru.elminn.weater_mvvm.data.repository.weather.WeatherRepositoryImpl
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun weaterRepository(client: RxWeatherClient): WeatherRepository = WeatherRepositoryImpl(client)

}
