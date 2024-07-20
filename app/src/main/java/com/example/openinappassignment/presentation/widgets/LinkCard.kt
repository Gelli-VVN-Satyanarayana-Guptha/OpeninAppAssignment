package com.example.openinappassignment.presentation.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.openinappassignment.R
import com.example.openinappassignment.domain.model.LinkData
import com.example.openinappassignment.presentation.custom.dashedBorder
import com.example.openinappassignment.presentation.ui.theme.OpeninAppAssignmentTheme
import com.example.openinappassignment.presentation.utils.formatDate

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LinkCard (
    link: LinkData
) {
    Card (
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box (
                modifier = Modifier
                    .height(72.dp)
                    .width(72.dp)
                    .border(
                        border = BorderStroke(width = Dp.Hairline, color = Color.LightGray),
                        shape = RoundedCornerShape(10)
                    )
                    .clip(RoundedCornerShape(15)),
                contentAlignment = Alignment.Center
            ) {
                GlideImage (
                    model = link.originalImage,
                    contentDescription = "applicationLogo"
                )
            }
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row (
                    modifier = Modifier.padding(start = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text (
                        modifier = Modifier.weight(1f),
                        text = link.title.toString(),
                        color = Color.Black,
                        fontSize = 18.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text (
                        modifier = Modifier.padding(start = 12.dp),
                        text = link.totalClicks.toString(),
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                }

                Row (
                    modifier = Modifier.padding(start = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text (
                        modifier = Modifier.weight(1f),
                        text = link.createdAt?.let { formatDate(it) } ?: "",
                        color = Color.Gray,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Text (
                        modifier = Modifier.padding(start = 12.dp),
                        text = "Clicks",
                        color = Color.Gray,
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                }
            }
        }

        // Link
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFE8F1FF))
                .dashedBorder (
                    brush = SolidColor(Color.Blue.copy(alpha = 0.2f)),
                    strokeWidth = 2.dp,
                    cap = StrokeCap.Square,
                    shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.weight(1f)
                    .padding(start = 16.dp, top = 12.dp, bottom = 12.dp),
                text = link.webLink.toString(),
                color = Color.Blue,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Icon(
                modifier = Modifier.padding(horizontal = 16.dp),
                painter = painterResource(R.drawable.files),
                contentDescription = "copy",
                tint = Color.Blue
            )
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun LinkCardPreview() {
    OpeninAppAssignmentTheme {
        LinkCard(
            LinkData (
                urlId =  146150,
                webLink =  "https://inopenapp.com/4o5qk",
                smartLink = "inopenapp.com/4o5qk",
                title = "Flats for Rent in Kormangla Bangalore, Bangalore Karnataka Without Brokerage - NoBroker Rental Properties in Kormangla Bangalore Karnataka Without Brokerage",
                totalClicks =  344,
                originalImage =  "https://assets.nobroker.in/nb-new/public/List-Page/ogImage.png",
                thumbnail =  null,
                timesAgo =  "1 yr ago",
                createdAt =  "2023-03-15T07:33:50.000Z",
                domainId = "inopenapp.com/",
                urlPrefix =  null,
                urlSuffix =  "4o5qk",
                app = "nobroker",
                isFavourite = false
            )
        )
    }
}*/
