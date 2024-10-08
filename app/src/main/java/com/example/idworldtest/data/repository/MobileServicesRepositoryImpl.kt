package com.example.idworldtest.data.repository

import android.util.Log
import com.example.idworldtest.data.source.availabillity.MobileServicesAvailabilityDataSource
import com.example.idworldtest.domain.MobileServiceEnvironment
import com.example.idworldtest.domain.MobileServicesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MobileServicesRepositoryImpl @Inject
constructor(
    private val mobileServices: List<@JvmSuppressWildcards MobileServicesAvailabilityDataSource>
) : MobileServicesRepository {

    override suspend fun getAvailableServices(): Set<MobileServiceEnvironment> =
        withContext(Dispatchers.IO) {
            val results = mutableSetOf<MobileServiceEnvironment>()

            for (service in mobileServices) {
                try {
                    val state = service.getState()
                    if (state != null) {
                        results.add(state)
                    }
                } catch (e: Exception) {
                    Log.e("MobileServicesRepository", "Error fetching service state: ${e.message}")
                }
            }

            return@withContext results
        }
}
