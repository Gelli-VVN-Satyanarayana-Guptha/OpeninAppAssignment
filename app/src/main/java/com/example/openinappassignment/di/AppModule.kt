package com.example.openinappassignment.di

import com.example.openinappassignment.BuildConfig
import com.example.openinappassignment.data.DashboardApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class KotlinxSerializationFactory

@Module
@InstallIn( SingletonComponent::class )
object AppModule {

    @Provides
    @Singleton
    fun provideDashboardApi(
        @KotlinxSerializationFactory kotlinxSerializationFactory: Converter.Factory
    ) : DashboardApi {
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
            val authToken = BuildConfig.AuthToken
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $authToken")
                .build()
            chain.proceed(newRequest)
        }).build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(DashboardApi.BASE_URL)
            .addConverterFactory(kotlinxSerializationFactory)
            .build()
            .create(DashboardApi::class.java)
    }

    @Provides
    @Singleton
    @KotlinxSerializationFactory
    fun provideKotlinxSerializationFactory() : Converter.Factory {
        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
        return json.asConverterFactory(contentType)
    }
}