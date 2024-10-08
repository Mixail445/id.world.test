package com.example.idworldtest.ui.screenMain

import androidx.compose.ui.graphics.Color

interface ScreenMainView {
    data class Model(
        val latitude: String = "",
        val longitude: String = "",
        val operatorText: String = "",
        val operatorColor: Color? = null,
    )

    sealed class Event

    sealed class UiLabel
}