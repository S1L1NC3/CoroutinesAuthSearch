package com.dmd.coroutinesauthsearch.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule { //Instead of creating instance every time of retrofit we will create one time for memory management easier
    @Singleton
    @Provides
    fun provideTestString() = "testString For DI"

}