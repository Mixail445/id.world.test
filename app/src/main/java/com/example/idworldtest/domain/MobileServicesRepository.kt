package com.example.idworldtest.domain

interface MobileServicesRepository {

    suspend fun getAvailableServices(): Set<MobileServiceEnvironment>
}