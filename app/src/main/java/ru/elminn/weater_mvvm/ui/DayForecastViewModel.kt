package ru.elminn.weater_mvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.elminn.weater_mvvm.data.repository.RepositoryProvider

class DayForecastViewModel : ViewModel() {

    companion object {
        private const val DEFAULT_CITY = "Kazan"
    }
    private val compositeDisposable = CompositeDisposable()

    private val _viewState = MutableLiveData<DayForecastViewState>()

    val view : LiveData<DayForecastViewState>
    get() = _viewState
/*init {
    this.view = view
}*/
  /*  fun DayForecastViewModel(view: DayForecastView) {
        this.view = view
    }
*/

    fun action(action: DayForecastAction) {
        when (action) {
            is DayForecastAction.FetchForecast -> fetchCityWeather(DEFAULT_CITY)
        }
    }

override fun onCleared() {
    compositeDisposable.clear()
}

    private fun fetchCityWeather(city: String) {
        compositeDisposable.add(
            RepositoryProvider.get()
                .provideNewsFeedRepository()
                .getDayForecast(city)
                .flatMap { dayForecastResponse -> Single.just(dayForecastResponse.getDayForecastInfo().getDayTempInfo()) }
                .map { it -> fromKelvinToCelsius(it) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { _viewState.value = DayForecastViewState.Loading }
                //.doFinally { view.hideProgressBar() }
                .subscribe (
                    { _viewState.value = DayForecastViewState.Success(it) },
                    {
                        _viewState.value = DayForecastViewState.Failure(it.message?:"")
                    })
        )
    }

    private fun fromKelvinToCelsius(temperature: Float): Float {
        return temperature - 273.15f
    }
}