package ru.elminn.weater_mvvm.ui

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.ac_day_forecast.*
import ru.elminn.weater_mvvm.MyApplication
import ru.elminn.weater_mvvm.R
import javax.inject.Inject


class DayForecastActivity : AppCompatActivity() {

    private lateinit var dayInfoView: TextView
    private lateinit var progressBar: ProgressBar
    @Inject
    lateinit var mViewModel: DayForecastViewModel
    //lateinit var viewModel: DayForecastViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_day_forecast)

        MyApplication.getApp(this).getAppComponent().createMainComponent().injectDayForecastActivity(this)
        dayInfoView = findViewById(R.id.tvDayForecast)
        progressBar = findViewById(R.id.progressBar)
        var editText = findViewById<EditText>(R.id.testEditView)
        findViewById<Button>(R.id.inputString).setOnClickListener {
            editText.setText("Lalala")
        }
        editText.setOnClickListener {
            //editText.setText("Lalala")
        }
        //mViewModel = ViewModelProviders.of(this).get(DayForecastViewModel::class.java)
        //  mViewModel.onRefreshWeatherClick()

        findViewById<View>(R.id.btnLoadWithRxJava)
            .setOnClickListener { mViewModel.action(DayForecastAction.FetchForecast) }

        mViewModel.view.observe(this, Observer { state ->
            state?.let { render(it) }
        })
    }

    private fun render(state: DayForecastViewState) {
        when (state) {
            is DayForecastViewState.Loading -> showProgressBar()
            is DayForecastViewState.Success -> {
                hideProgressBar()
                showTemperatureInCelsius(state.temp)
            }
            is DayForecastViewState.Failure -> {
                hideProgressBar()
                Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show();
            }
        }
    }


    fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    fun showTemperatureInCelsius(temperatureInCelsius: Float) {
        dayInfoView.text = getString(R.string.temp_celsius_pattern, temperatureInCelsius)
    }
}