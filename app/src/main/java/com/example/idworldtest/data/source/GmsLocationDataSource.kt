package com.example.idworldtest.data.source

import android.annotation.SuppressLint
import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.tasks.Tasks

class GmsLocationDataSource(
    private val locationProvider: FusedLocationProviderClient,
) {
    @SuppressLint("MissingPermission")
    fun getLastLocation(): Result<Location?> {
        return try {
            val location = Tasks.await(locationProvider.lastLocation)
            Result.success(location)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}