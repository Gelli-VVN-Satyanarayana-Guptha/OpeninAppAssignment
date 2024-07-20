package com.example.openinappassignment.presentation.screens.dashboard

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openinappassignment.data.DashboardApi
import com.example.openinappassignment.domain.model.DashboardData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor (
    private val dashboardApi: DashboardApi
) : ViewModel() {
    val dashboardData = mutableStateOf<DashboardData?>(null)

    init {
        loadDashboardData()
    }

    private fun loadDashboardData() {
        viewModelScope.launch {
            try {
                val dashboardData = dashboardApi.getDashboardData()
                this@DashboardViewModel.dashboardData.value = dashboardData.toDashboardData()
            } catch (e: Exception) {
                // Handle error
                Log.e(TAG, "Error loading dashboard data", e)
            }
        }
    }

    companion object {
        const val TAG = "DashboardViewModel"
    }
}