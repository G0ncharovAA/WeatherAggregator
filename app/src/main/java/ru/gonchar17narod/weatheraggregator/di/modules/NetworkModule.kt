package ru.gonchar17narod.weatheraggregator.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.gonchar17narod.weatheraggregator.BuildConfig
import ru.gonchar17narod.weatheraggregator.data.network.OpenweathermapService

@Module
@InstallIn(ActivityRetainedComponent::class)
class NetworkModule {

    @Provides
    @ActivityRetainedScoped
    fun provideInterceptor(): Interceptor =
        Interceptor {
            with(
                it.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter(
                        "mode",
                        "json"
                    )
                    .addQueryParameter(
                        "appid",
                        BuildConfig.OWM_APP_ID
                    )
                    .build()
            ) {
                it.proceed(
                    it.request()
                        .newBuilder()
                        .url(this)
                        .build()
                )
            }
        }

    @Provides
    @ActivityRetainedScoped
    fun provideOohttpclient(
        interceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    @Provides
    @ActivityRetainedScoped
    fun provideGsonCoverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    @ActivityRetainedScoped
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org")
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()


    @Provides
    @ActivityRetainedScoped
    fun provideOpenweathermapService(
        retrofit: Retrofit
    ): OpenweathermapService =
        retrofit.create(OpenweathermapService::class.java)
}