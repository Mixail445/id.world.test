package com.example.idworldtest.domain

import android.location.Location


interface LocationRepository {
    suspend fun getLastLocation(mobileServiceType: MobileServiceType): Result<Location?>
}