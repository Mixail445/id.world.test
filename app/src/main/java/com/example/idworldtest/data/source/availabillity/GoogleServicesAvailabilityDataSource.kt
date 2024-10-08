package com.example.idworldtest.data.source.availabillity

import android.content.Context
import com.example.idworldtest.domain.MobileServiceEnvironment
import com.google.android.gms.common.ConnectionResult.SERVICE_UPDATING
import com.google.android.gms.common.ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED
import com.google.android.gms.common.ConnectionResult.SUCCESS
import com.google.android.gms.common.GoogleApiAvailability
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GoogleServicesAvailabilityDataSource @Inject
constructor(
    private val appContext: Context,
    private val googleApiAvailability: GoogleApiAvailability
) : MobileServicesAvailabilityDataSource {

    /**
     * [GoogleApiAvailability doc](https://developers.google.com/android/reference/com/google/android/gms/common/GoogleApiAvailability)
     */
    override suspend fun getState(): MobileServiceEnvironment = withContext(Dispatchers.IO) {

        val connectionResult = googleApiAvailability.isGooglePlayServicesAvailable(appContext)

        when (connectionResult) {
            SUCCESS -> MobileServiceEnvironment.GoogleMobileServices(false)
            SERVICE_UPDATING,
            SERVICE_VERSION_UPDATE_REQUIRED -> MobileServiceEnvironment.GoogleMobileServices(true)
            else -> {
                TODO()
            }
        }
    }
}

