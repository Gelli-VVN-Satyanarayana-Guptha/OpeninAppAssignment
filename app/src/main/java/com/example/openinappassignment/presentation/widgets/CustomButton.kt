package com.example.openinappassignment.presentation.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton (
    modifier: Modifier = Modifier,
    text: String,
    iconRes: Int,
    onClick: () -> Unit,
    baseColor: Color,
    backgroundColor: Color = baseColor.copy(alpha = 0.12f),
    horizontalArrangement: Arrangement.Horizontal = Arrangement.Center
) {
    Box (
        modifier = modifier.fillMaxWidth()
            .clip(RoundedCornerShape(15))
            .background(backgroundColor)
            .border(
                BorderStroke(
                    width = Dp.Hairline,
                    color = baseColor.copy(alpha = 0.32f)
                ),
                RoundedCornerShape(15)
            )
            .clickable { onClick() }
    ) {
        Row (
            modifier = Modifier.fillMaxWidth().padding(18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = horizontalArrangement
        ) {
            Icon (
                painter = painterResource(id = iconRes),
                contentDescription = "Button Icon",
                tint = baseColor
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text (
                modifier = Modifier.weight(1f, fill = false),
                text = text,
                color = Color.Black,
                style = MaterialTheme.typography.headlineSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}