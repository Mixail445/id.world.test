package com.example.idworldtest.domain

interface ClientResourceProvider {
    fun getClientName(): String
    fun getClientColor(): androidx.compose.ui.graphics.Color
}