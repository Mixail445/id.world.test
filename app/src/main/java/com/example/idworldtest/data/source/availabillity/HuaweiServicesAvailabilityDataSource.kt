package com.example.idworldtest.data.source.availabillity

import android.content.Context
import com.example.idworldtest.domain.MobileServiceEnvironment
import com.huawei.hms.api.ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED
import com.huawei.hms.api.ConnectionResult.SUCCESS
import com.huawei.hms.api.HuaweiApiAvailability
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HuaweiServicesAvailabilityDataSource(
    private val appContext: Context,
    private val huaweiApiAvailability: HuaweiApiAvailability,
    private val emuiDataSource: EmuiDataSource
) : MobileServicesAvailabilityDataSource {

    /**
     * Проверяем доступность Huawei Mobile Services и возвращаем состояние.
     */
    override suspend fun getState(): MobileServiceEnvironment? = withContext(Dispatchers.IO) {
        val connectionResult = huaweiApiAvailability.isHuaweiMobileServicesAvailable(appContext)

        val isUpdateRequired = when (connectionResult) {
            SUCCESS -> false
            SERVICE_VERSION_UPDATE_REQUIRED -> true
            else -> return@withContext null
        }

        appendEmuiApiLevel(isUpdateRequired)
    }

    private suspend fun appendEmuiApiLevel(isUpdateRequired: Boolean): MobileServiceEnvironment.HuaweiMobileServices {
        val apiLevel =
            emuiDataSource.getEmuiApiLevel()
        return MobileServiceEnvironment.HuaweiMobileServices(isUpdateRequired, apiLevel)
    }
}