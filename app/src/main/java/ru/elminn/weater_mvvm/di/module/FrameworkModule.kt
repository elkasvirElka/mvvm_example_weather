package ru.elminn.weater_mvvm.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.elminn.weater_mvvm.BuildConfig
import ru.elminn.weater_mvvm.framework.network.OkHttpProvider
import ru.elminn.weater_mvvm.framework.network.clients.RxWeatherClient
import javax.inject.Singleton

@Module
class FrameworkModule {

    @Singleton
    @Provides
    fun getRetrofitInstance(): RxWeatherClient {
    var retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .client(provideClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        return retrofit.create(RxWeatherClient::class.java)
    }


    private fun provideClient(): OkHttpClient {
            var sHttpClient = OkHttpProvider.provideClient()
        return sHttpClient
    }
}