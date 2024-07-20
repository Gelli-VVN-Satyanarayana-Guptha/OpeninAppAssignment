package com.example.openinappassignment.domain.model

data class DashboardData (
    var supportWhatsappNumber : String?  = null,
    var extraIncome           : Double?  = null,
    var totalLinks            : Int?     = null,
    var totalClicks           : Int?     = null,
    var todayClicks           : Int?     = null,
    var topSource             : String?  = null,
    var topLocation           : String?  = null,
    var startTime             : String?  = null,
    var linksCreatedToday     : Int?     = null,
    var appliedCampaign       : Int?     = null,
    var data                  : ListsData?    = null
)
