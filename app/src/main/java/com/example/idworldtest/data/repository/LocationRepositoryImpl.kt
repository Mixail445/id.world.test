package com.example.idworldtest.data.repository

import android.location.Location
import com.example.idworldtest.data.source.GmsLocationDataSource
import com.example.idworldtest.data.source.HmsLocationDataSource
import com.example.idworldtest.domain.LocationRepository
import com.example.idworldtest.domain.MobileServiceType
import javax.inject.Inject

class LocationRepositoryImpl @Inject
constructor(
    private val hmsLocationDataSource: HmsLocationDataSource,
    private val gmsLocationDataSource: GmsLocationDataSource
) : LocationRepository {
    override suspend fun getLastLocation(mobileServiceType: MobileServiceType): Result<Location?> {
        return when (mobileServiceType) {
            MobileServiceType.Google -> gmsLocationDataSource.getLastLocation()
            MobileServiceType.Huawei -> hmsLocationDataSource.getLastLocation()
        }
    }

}