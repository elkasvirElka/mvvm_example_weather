package ru.elminn.weater_mvvm.ui.dayforecast

sealed class DayForecastAction {
    object FetchForecast : DayForecastAction()
}