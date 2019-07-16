package ru.elminn.weater_mvvm.ui

sealed class DayForecastAction {
    object FetchForecast : DayForecastAction()
}