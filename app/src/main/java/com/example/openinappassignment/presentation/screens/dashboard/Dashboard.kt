package com.example.openinappassignment.presentation.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.openinappassignment.R
import com.example.openinappassignment.domain.model.DashboardData
import com.example.openinappassignment.domain.model.LinksList
import com.example.openinappassignment.presentation.widgets.Analytics
import com.example.openinappassignment.presentation.widgets.Chart
import com.example.openinappassignment.presentation.widgets.CustomButton
import com.example.openinappassignment.presentation.widgets.CustomNavigationBar
import com.example.openinappassignment.presentation.widgets.Greetings

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard (
    username: String = "Satya Gelli",
) {
    val viewModel = hiltViewModel<DashboardViewModel>()
    val dashboardData = viewModel.dashboardData.value

    val links = getLinksList(dashboardData)

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { DashboardTopBar(title = "Dashboard", scrollBehavior) },
        bottomBar = { CustomNavigationBar() }
    ) { paddingValues ->
        Column (
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {

            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    .background(Color(0xFF0E6FFF))
            ) {
                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                        .background(color = MaterialTheme.colorScheme.background)
                ) {
                    Spacer(modifier = Modifier.fillMaxSize())
                }
            }

            WelcomeUser (username = username)
            Spacer(modifier = Modifier.height(18.dp))
            Chart(dashboardData?.data?.overallUrlChart)
            Spacer(modifier = Modifier.height(18.dp))
            Analytics (
                todayClick = dashboardData?.todayClicks,
                topLocation = dashboardData?.topLocation,
                topSource = dashboardData?.topSource,
            )
            Spacer(modifier = Modifier.height(18.dp))
            CustomButton (
                modifier = Modifier.padding(horizontal = 20.dp),
                text = "View Analytics",
                onClick = { /*TODO*/ },
                baseColor = Color.Black,
                backgroundColor = Color.White,
                iconRes = R.drawable.analytics
            )
            Spacer(modifier = Modifier.height(24.dp))
            LinkSection(linksList = links)
            Spacer(modifier = Modifier.height(38.dp))
            CustomButton (
                modifier = Modifier.padding(horizontal = 20.dp),
                text = "Talk with us",
                onClick = { /*TODO*/ },
                baseColor = Color.Green,
                iconRes = R.drawable.whatsapp,
                horizontalArrangement = Arrangement.Start
            )
            Spacer(modifier = Modifier.height(20.dp))
            CustomButton (
                modifier = Modifier.padding(horizontal = 20.dp),
                text = "Frequently Asked Questions",
                onClick = { /*TODO*/ },
                baseColor = Color.Blue,
                iconRes = R.drawable.doubts,
                horizontalArrangement = Arrangement.Start
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardTopBar (
    title : String,
    scrollBehaviour: TopAppBarScrollBehavior
) {
    LargeTopAppBar (
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = Color(0xFF0E6FFF),
            scrolledContainerColor = Color(0xFF0E6FFF)
        ),
        title = {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text (
                        modifier = Modifier.weight(1f),
                        text = title,
                        color = Color.White,
                        style = MaterialTheme.typography.headlineLarge,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Box (
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .height(42.dp)
                            .width(42.dp)
                            .clip(RoundedCornerShape(20))
                            .background(color = Color.White.copy(alpha = 0.12f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.wrench),
                            tint = Color.White,
                            contentDescription = "settings"
                        )
                    }
                }
            }
        },
        scrollBehavior = scrollBehaviour
    )
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun WelcomeUser(
    username: String
) {
    Column (
        modifier = Modifier.padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Greetings()
        Spacer(modifier = Modifier.height(8.dp))
        Row (
            modifier = Modifier.wrapContentWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text (
                modifier = Modifier.weight(1f, fill = false),
                text = username,
                color = Color.Black,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.width(12.dp))
            GlideImage (
                modifier = Modifier
                    .size(38.dp)
                    .scale(scaleX = -1f, scaleY = 1f),
                model = R.drawable.hi,
                contentDescription = "Hi"
            )
        }
    }
}

fun getLinksList (
    dashboardData: DashboardData?
) : List<LinksList> {

    val links = mutableListOf<LinksList>()

    dashboardData?.data?.topLinks?.let {
        links.add(
            LinksList (
                linksType = "Top Links",
                links = it
            )
        )
    }

    dashboardData?.data?.recentLinks?.let {
        links.add(
            LinksList(
                linksType = "Recent Links",
                links = it
            )
        )
    }

    dashboardData?.data?.favouriteLinks?.let {
        links.add(
            LinksList(
                linksType = "Favourite Links",
                links = it
            )
        )
    }
    return links
}
