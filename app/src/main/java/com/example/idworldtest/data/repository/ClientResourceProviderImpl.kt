package com.example.idworldtest.data.repository

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import com.example.idworldtest.R
import com.example.idworldtest.domain.ClientResourceProvider
import javax.inject.Inject

class ClientResourceProviderImpl @Inject constructor(private val context: Context) :
    ClientResourceProvider {
    override fun getClientName(): String {
        return context.getString(R.string.client_name)
    }

    override fun getClientColor(): Color {
        val clientColor: Int = ContextCompat.getColor(context, R.color.client_color)
        return Color(clientColor)
    }
}