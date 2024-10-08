package com.example.idworldtest.di

import android.app.Application
import android.content.Context
import com.example.idworldtest.data.repository.ClientResourceProviderImpl
import com.example.idworldtest.domain.ClientResourceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }
    @Provides
    @Singleton
    fun provideClientResourceProvider(clientResourceProviderImpl: ClientResourceProviderImpl): ClientResourceProvider =clientResourceProviderImpl
}