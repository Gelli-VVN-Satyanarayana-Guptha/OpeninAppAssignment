package com.example.openinappassignment.data

import com.example.openinappassignment.data.remote.dto.DashboardDto
import retrofit2.http.GET

interface DashboardApi {

    @GET("dashboardNew")
    suspend fun getDashboardData() : DashboardDto

    companion object{
        const val BASE_URL = "https://api.inopenapp.com/api/v1/"
    }
}