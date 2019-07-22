package ru.elminn.weater_mvvm.di

import ru.elminn.weater_mvvm.framework.network.ApiFactory
import ru.elminn.weater_mvvm.framework.network.clients.RxWeatherClient
import ru.elminn.weater_mvvm.data.repository.weather.WeatherRepository
import ru.elminn.weater_mvvm.data.repository.weather.WeatherRepositoryImpl

object InjectorUtils {
    fun provideRepositoryViewModel() : WeatherRepository {
        var weatherRepository =
            WeatherRepositoryImpl(ApiFactory.getRetrofitInstance().create((RxWeatherClient::class.java)))
        return weatherRepository
    }
}