package com.example.idworldtest.domain

class SelectMobileServiceType(
    private val mobileServicesRepository: MobileServicesRepository
) {

    suspend operator fun invoke(case: Case): Result<MobileServiceType> {
        return runCatching {
            val availableServices = mobileServicesRepository.getAvailableServices()
            val filteredEnvironments = excludeEnvironmentsByCase(case, availableServices)
            selectEnvironment(filteredEnvironments)?.mobileServiceType
                ?: throw Exception("No suitable mobile service environment found")
        }
    }

    private fun excludeEnvironmentsByCase(
        case: Case,
        envs: Set<MobileServiceEnvironment>
    ): Iterable<MobileServiceEnvironment> = when (case) {
        Case.Push, Case.Map, Case.Location -> envs
        Case.Security -> envs.filter { !it.isUpdateRequired }
    }

    private fun selectEnvironment(
        envs: Iterable<MobileServiceEnvironment>
    ): MobileServiceEnvironment? {
        val huaweiService = envs.firstOrNull {
            it is MobileServiceEnvironment.HuaweiMobileServices && (it.emuiApiLevel == null || it.emuiApiLevel >= 21)
        }
        val googleService = envs.firstOrNull { it is MobileServiceEnvironment.GoogleMobileServices }

        if (huaweiService != null) return huaweiService

        return googleService
    }

    enum class Case {
        Push, Map, Security, Location
    }
}