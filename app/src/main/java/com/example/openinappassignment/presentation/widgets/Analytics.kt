package com.example.openinappassignment.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.openinappassignment.R

@Composable
fun Analytics (
    todayClick: Int?,
    topLocation: String?,
    topSource: String?
) {
    Row (
        modifier = Modifier.horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Spacer(modifier = Modifier.width(2.dp))

        AnalyticsCard(
            title = "Today's Clicks",
            value = todayClick?.toString() ?: "N/A",
            iconRes = R.drawable.clicks,
            iconColor = Color.Blue
        )

        AnalyticsCard (
            title = "Top Location",
            value = topLocation ?: "N/A",
            iconRes = R.drawable.location,
            iconColor = Color.Blue
        )

        AnalyticsCard (
            title = "Top Source",
            value = topSource ?: "N/A",
            iconRes = R.drawable.website,
            iconColor = Color.Red
        )
    }
}

@Composable
fun AnalyticsCard (
    title: String,
    value: String,
    iconRes: Int,
    iconColor: Color
) {
    Card (
        modifier = Modifier.size(160.dp),
        shape = RoundedCornerShape(15),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Column (
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 18.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Box (
                modifier = Modifier
                    .size(52.dp)
                    .clip(RoundedCornerShape(50))
                    .background(iconColor.copy(alpha = 0.12f)),
                contentAlignment = Alignment.Center
            ) {
                Icon (
                    painter = painterResource(id = iconRes),
                    tint = iconColor,
                    contentDescription = title
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text (
                text = value,
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text (
                text = title,
                color = Color.Gray,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}