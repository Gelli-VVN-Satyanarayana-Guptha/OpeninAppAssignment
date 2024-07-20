package com.example.openinappassignment.data.remote.dto

import com.example.openinappassignment.domain.model.DashboardData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DashboardDto(
    @SerialName("status"                  ) var status                : Boolean? = null,
    @SerialName("statusCode"              ) var statusCode            : Int?     = null,
    @SerialName("message"                 ) var message               : String?  = null,
    @SerialName("support_whatsapp_number" ) var supportWhatsappNumber : String?  = null,
    @SerialName("extra_income"            ) var extraIncome           : Double?  = null,
    @SerialName("total_links"             ) var totalLinks            : Int?     = null,
    @SerialName("total_clicks"            ) var totalClicks           : Int?     = null,
    @SerialName("today_clicks"            ) var todayClicks           : Int?     = null,
    @SerialName("top_source"              ) var topSource             : String?  = null,
    @SerialName("top_location"            ) var topLocation           : String?  = null,
    @SerialName("startTime"               ) var startTime             : String?  = null,
    @SerialName("links_created_today"     ) var linksCreatedToday     : Int?     = null,
    @SerialName("applied_campaign"        ) var appliedCampaign       : Int?     = null,
    @SerialName("data"                    ) var data                  : Data?    = null
) {
    fun toDashboardData() : DashboardData {
        return DashboardData(
            supportWhatsappNumber = supportWhatsappNumber,
            extraIncome = extraIncome,
            totalLinks = totalLinks,
            totalClicks = totalClicks,
            todayClicks = todayClicks,
            topSource = topSource,
            topLocation = topLocation,
            startTime = startTime,
            linksCreatedToday = linksCreatedToday,
            appliedCampaign = appliedCampaign,
            data = data?.toListsData()
        )
    }

}
