package com.example.idworldtest.data.source

import android.location.Location
import com.huawei.hmf.tasks.Tasks
import com.huawei.hms.location.FusedLocationProviderClient

class HmsLocationDataSource(
    private val locationProvider: FusedLocationProviderClient,
) {
    fun getLastLocation(): Result<Location?> {
        return try {
            val location = Tasks.await(locationProvider.lastLocation)
            Result.success(location)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
