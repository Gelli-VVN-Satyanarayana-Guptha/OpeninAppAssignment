package com.example.openinappassignment.presentation.widgets

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import java.time.LocalTime

@Composable
fun Greetings(
    hour: Int = LocalTime.now().hour
) {
    val greetingText = when (hour) {
        in 5..11 -> "Good Morning"
        in 12..17 -> "Good Afternoon"
        else -> "Good Evening"
    }

    // Display time based greetings
    Text (
        text = greetingText,
        color = Color.Gray,
        fontSize = 22.sp,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}