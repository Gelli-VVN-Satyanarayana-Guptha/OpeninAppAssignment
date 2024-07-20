package com.example.openinappassignment.presentation.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.openinappassignment.R

// Custom Navigation Bar
// ToDo Need to customize further and add nav controller
@Composable
fun CustomNavigationBar() {
    var selectedItem by remember { mutableStateOf("Links") }
    val items = mapOf(
        "Links" to R.drawable.link,
        "Courses" to R.drawable.courses,
        "Campaigns" to R.drawable.campaign,
        "Profile" to R.drawable.profile
    )

    NavigationBar (
        containerColor = Color.White,
    ) {
        items.forEach { (key, item) ->
            val isSelected = selectedItem == key
            NavigationBarItem(
                icon = {
                    Box (
                        modifier = Modifier.size(32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon (
                            painter = painterResource(item),
                            contentDescription = key,
                            tint = if (isSelected) Color.Black else Color.Gray
                        )
                    } },
                label = {
                    Text (
                        text = key,
                        color = if (isSelected) Color.Black else Color.Gray,
                    ) },
                selected = isSelected,
                onClick = { selectedItem = key }
            )
        }
    }
}

