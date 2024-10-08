package com.example.idworldtest.data.source.availabillity

import com.example.idworldtest.domain.MobileServiceEnvironment

interface MobileServicesAvailabilityDataSource {

    suspend fun getState(): MobileServiceEnvironment?
}