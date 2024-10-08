package com.example.idworldtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.idworldtest.ui.screenMain.ScreenMain
import com.example.idworldtest.ui.theme.IdworldtestTheme
import com.example.idworldtest.utils.PermissionManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val permissionManager = PermissionManager(this)
        permissionManager.requestLocationPermissions()
        setContent {
            IdworldtestTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    ScreenMain(
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}
