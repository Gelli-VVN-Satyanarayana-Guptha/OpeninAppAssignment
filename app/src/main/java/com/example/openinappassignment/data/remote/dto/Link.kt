package com.example.openinappassignment.data.remote.dto

import com.example.openinappassignment.domain.model.LinkData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Link(
    @SerialName("url_id"         ) var urlId         : Int?     = null,
    @SerialName("web_link"       ) var webLink       : String?  = null,
    @SerialName("smart_link"     ) var smartLink     : String?  = null,
    @SerialName("title"          ) var title         : String?  = null,
    @SerialName("total_clicks"   ) var totalClicks   : Int?     = null,
    @SerialName("original_image" ) var originalImage : String?  = null,
    @SerialName("thumbnail"      ) var thumbnail     : String?  = null,
    @SerialName("times_ago"      ) var timesAgo      : String?  = null,
    @SerialName("created_at"     ) var createdAt     : String?  = null,
    @SerialName("domain_id"      ) var domainId      : String?  = null,
    @SerialName("url_prefix"     ) var urlPrefix     : String?  = null,
    @SerialName("url_suffix"     ) var urlSuffix     : String?  = null,
    @SerialName("app"            ) var app           : String?  = null,
    @SerialName("is_favourite"   ) var isFavourite   : Boolean? = null
) {
    fun toLinkData(): LinkData {
        return LinkData(
            urlId = urlId,
            webLink = webLink,
            smartLink = smartLink,
            title = title,
            totalClicks = totalClicks,
            originalImage = originalImage,
            thumbnail = thumbnail,
            timesAgo = timesAgo,
            createdAt = createdAt,
            domainId = domainId,
            urlPrefix = urlPrefix,
            urlSuffix = urlSuffix,
            app = app,
            isFavourite = isFavourite
        )
    }
}
