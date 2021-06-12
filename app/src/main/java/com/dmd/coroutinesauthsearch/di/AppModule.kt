package com.dmd.coroutinesauthsearch.di

import com.dmd.coroutinesauthsearch.api.AuthenticationApi
import com.dmd.coroutinesauthsearch.api.QueryApi
import com.dmd.coroutinesauthsearch.constants.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule { //Instead of creating instance every time of retrofit we will create one time for memory management easier
    @Singleton
    @Provides
    fun provideTestString() = "testString For DI"

    @Singleton
    @Provides
    fun provideBaseUrl() = ApiConstants.BASE_URL

    @Singleton
    @Provides
    fun provideRetrofitAuthentication(BASE_URL: String): AuthenticationApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthenticationApi::class.java)

    @Singleton
    @Provides
    fun provideRetrofitQuery(BASE_URL: String): QueryApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QueryApi::class.java)

}