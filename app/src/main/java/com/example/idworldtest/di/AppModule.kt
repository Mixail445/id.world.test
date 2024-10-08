package com.example.idworldtest.di

import android.app.Application
import android.content.Context
import com.example.idworldtest.data.repository.ClientResourceProviderImpl
import com.example.idworldtest.data.repository.MobileServicesRepositoryImpl
import com.example.idworldtest.data.source.availabillity.EmuiDataSource
import com.example.idworldtest.data.source.availabillity.GoogleServicesAvailabilityDataSource
import com.example.idworldtest.data.source.availabillity.HuaweiServicesAvailabilityDataSource
import com.example.idworldtest.data.source.availabillity.MobileServicesAvailabilityDataSource
import com.example.idworldtest.domain.ClientResourceProvider
import com.example.idworldtest.domain.MobileServicesRepository
import com.example.idworldtest.domain.SelectMobileServiceType
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.huawei.hms.api.HuaweiApiAvailability
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
    fun provideClientResourceProvider(clientResourceProviderImpl: ClientResourceProviderImpl):ClientResourceProvider=clientResourceProviderImpl


    @Provides
    @Singleton
    fun provideGoogleApiAvailability(): GoogleApiAvailability {
        return GoogleApiAvailability.getInstance()
    }

    @Provides
    @Singleton
    fun provideHuaweiApiAvailability(): HuaweiApiAvailability {
        return HuaweiApiAvailability.getInstance()
    }

    @Provides
    @Singleton
    fun provideEmuiDataSource(): EmuiDataSource {
        return EmuiDataSource()
    }

    @Provides
    fun provideSelectMobileServiceType(repository: MobileServicesRepository): SelectMobileServiceType {
        return SelectMobileServiceType(repository)
    }

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(context: Context): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(context)
    }


    @Provides
    @Singleton
    fun provideMobileServiceRepository(mobileServicesRepositoryImpl: MobileServicesRepositoryImpl): MobileServicesRepository {
        return mobileServicesRepositoryImpl
    }

    @Provides
    @Singleton
    fun provideMobileServicesAvailabilityDataSources(
        googleServices: GoogleServicesAvailabilityDataSource,
        huaweiServices: HuaweiServicesAvailabilityDataSource
    ): List<MobileServicesAvailabilityDataSource> {
        return listOf(googleServices, huaweiServices)
    }

    @Provides
    @Singleton
    fun provideHuaweiFusedLocationProviderClient(context: Context): com.huawei.hms.location.FusedLocationProviderClient {
        return com.huawei.hms.location.LocationServices.getFusedLocationProviderClient(context)
    }


    @Provides
    @Singleton
    fun provideHuaweiServicesAvailabilityDataSource(
        context: Context,
        huaweiApiAvailability: HuaweiApiAvailability,
        emuiDataSource: EmuiDataSource
    ): HuaweiServicesAvailabilityDataSource {
        return HuaweiServicesAvailabilityDataSource(context, huaweiApiAvailability, emuiDataSource)
    }

    @Provides
    @Singleton
    fun provideGoogleServicesAvailabilityDataSource(
        context: Context,
        googleApiAvailability: GoogleApiAvailability
    ): GoogleServicesAvailabilityDataSource {
        return GoogleServicesAvailabilityDataSource(context, googleApiAvailability)
    }
}