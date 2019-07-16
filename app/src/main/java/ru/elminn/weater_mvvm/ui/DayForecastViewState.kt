package ru.elminn.weater_mvvm.ui

sealed class DayForecastViewState {
    object Loading : DayForecastViewState()
    class Success(val temp: Float) : DayForecastViewState()
    class Failure(val message: String) : DayForecastViewState()
}