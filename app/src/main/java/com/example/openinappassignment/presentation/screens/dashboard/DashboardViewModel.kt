package com.example.openinappassignment.presentation.screens.dashboard

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
            dashboardData.value = dashboardApi.getDashboardData().toDashboardData()
        }
    }
}