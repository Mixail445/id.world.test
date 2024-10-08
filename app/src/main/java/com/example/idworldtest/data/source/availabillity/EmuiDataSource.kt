package com.example.idworldtest.data.source.availabillity

import android.annotation.SuppressLint
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EmuiDataSource {

    @SuppressLint("PrivateApi")
    suspend fun getEmuiApiLevel(): Int? = withContext(Dispatchers.IO) {
        return@withContext try {
            val clazz = Class.forName("android.os.SystemProperties")
            val get = clazz.getMethod("getInt", String::class.java, Int::class.java)
            val currentApiLevel = get.invoke(clazz, EMUI_API, UNKNOWN_API_LEVEL) as Int
            currentApiLevel.takeIf { it != UNKNOWN_API_LEVEL }
        } catch (e: Exception) {
            Log.e(LOG_TAG, "Unable to get EMUI api level", e)
            null
        }
    }

    private companion object {
        const val LOG_TAG = "EmuiDataSource"
        const val EMUI_API = "ro.build.hw_emui_api_level"
        const val UNKNOWN_API_LEVEL = -1
    }
}