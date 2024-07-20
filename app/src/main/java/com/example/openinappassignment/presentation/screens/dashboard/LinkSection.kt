package com.example.openinappassignment.presentation.screens.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.openinappassignment.R
import com.example.openinappassignment.domain.model.LinkData
import com.example.openinappassignment.domain.model.LinksList
import com.example.openinappassignment.presentation.widgets.CustomButton
import com.example.openinappassignment.presentation.widgets.LinkCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LinkSection (
    linksList: List<LinksList>,
) {
    val selectedIndex = remember { mutableIntStateOf(0) }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            LazyRow(
                modifier = Modifier.weight(1f, fill = false),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.width(12.dp))
                }
                itemsIndexed(linksList) { it, item ->
                    Header (
                        item.linksType,
                        isSelected = it == selectedIndex.intValue,
                        onClick = {
                            selectedIndex.intValue = it
                        }
                    )
                }
            }
            Box (
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .size(42.dp)
                    .clip(RoundedCornerShape(30))
                    .background(color = Color.LightGray.copy(alpha = 0.3f))
                    .border (
                        width = Dp.Hairline,
                        color = Color.Gray,
                        shape = RoundedCornerShape(30)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon (
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "Search",
                    tint = Color.Gray
                )
            }
        }
        if (selectedIndex.intValue < linksList.size) {
            ListLinks(links = linksList[selectedIndex.intValue].links)
        }
    }
}

@Composable
fun ListLinks (
    links: List<LinkData>
) {
    var showMore by rememberSaveable { mutableStateOf(false) }
    Column (
        modifier = Modifier.padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        links.takeIf { !showMore }?.take(4)?.forEach { item ->
            LinkCard(item)
        }

        if (showMore) {
            links.forEach { item ->
                LinkCard(item)
            }
        }

        CustomButton (
            text = if (showMore) "Hide Links" else "View all Links",
            iconRes = R.drawable.link,
            baseColor = Color.Black,
            backgroundColor = Color.White,
            onClick = { showMore = !showMore }
        )
    }
}

@Composable
fun Header(
    linksType: String?,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box (
        modifier = Modifier
            .height(42.dp)
            .clip(RoundedCornerShape(50))
            .background(color = if (isSelected) Color(0xFF0E6FFF) else Color.Transparent)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text (
            modifier = Modifier.padding(horizontal = 12.dp),
            text = linksType ?: "Header",
            color = if (isSelected) Color.White else Color.Gray,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1
        )
    }
}

