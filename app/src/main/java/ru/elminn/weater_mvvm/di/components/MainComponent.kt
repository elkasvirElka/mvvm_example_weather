package ru.elminn.weater_mvvm.di.components

import dagger.Subcomponent
import ru.elminn.weater_mvvm.ui.DayForecastActivity


@Subcomponent(modules = [])
interface MainComponent {

    fun injectDayForecastActivity(activity: DayForecastActivity)
}
