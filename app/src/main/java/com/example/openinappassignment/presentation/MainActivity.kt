package com.example.openinappassignment.presentation

import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.openinappassignment.presentation.screens.network.NoNetworkScreen
import com.example.openinappassignment.presentation.screens.dashboard.Dashboard
import com.example.openinappassignment.presentation.ui.theme.OpeninAppAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val connectivityManager: ConnectivityManager = getSystemService(ConnectivityManager::class.java)
        val networkInfo = connectivityManager.activeNetworkInfo
        val isConnected = networkInfo != null && networkInfo.isConnected

        setContent {
            OpeninAppAssignmentTheme {
                if (isConnected) {
                    Dashboard()
                } else {
                    NoNetworkScreen()
                }
            }
        }
    }
}