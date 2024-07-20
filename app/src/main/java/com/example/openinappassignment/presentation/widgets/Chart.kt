package com.example.openinappassignment.presentation.widgets

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.openinappassignment.R
import com.example.openinappassignment.presentation.utils.getHourFromString
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

@Composable
fun Chart (
    overallChartData: Map<String, Int>?,
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Spacer(modifier = Modifier.height(18.dp))
        // Header
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text (
                modifier = Modifier.weight(1f),
                text = "Overview",
                color = Color.Gray,
                style = MaterialTheme.typography.headlineSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Row (
                modifier = Modifier
                    .clip(RoundedCornerShape(20))
                    .background(color = Color.White.copy(alpha = 0.12f))
                    .border (
                        width = Dp.Hairline,
                        color = Color.Gray,
                        shape = RoundedCornerShape(30)
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text (
                    modifier = Modifier.padding(horizontal = 12.dp)
                        .weight(1f, fill = false),
                    text = "22 Aug - 23 Sep",
                    color = Color.Black,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.headlineSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Icon (
                    modifier = Modifier.padding(end = 12.dp),
                    painter = painterResource(R.drawable.time),
                    tint = Color.Gray,
                    contentDescription = "time"
                )
            }
        }
        overallChartData?.let {
            LineChartComponent (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 18.dp)
                    .aspectRatio(2f),
                lineData = LineData(convertDataSet(overallChartData)),
                update = { }
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
    }
}

fun convertDataSet(overallChartData: Map<String, Int>?): LineDataSet {
    val entries = mutableListOf<Entry>()
    for (data in overallChartData.orEmpty() ) {
        entries.add(Entry(getHourFromString(data.key).toFloat(), data.value.toFloat()))
    }
    return LineDataSet(entries, "count").apply {
        mode = LineDataSet.Mode.LINEAR
        color = android.graphics.Color.BLUE
        setDrawFilled(true)
        setDrawCircles(false)
        setDrawValues(false)
        setLineWidth(3f)
    }
}

@Composable
fun LineChartComponent(modifier: Modifier, lineData: LineData, update: () -> Unit) {
    // (x,y) -> Entry -> List<Entry> -> LineDataSet -> LineData -> LineChart
    AndroidView(
        modifier = modifier,
        factory = { context ->
            LineChart(context)
                .setupLineChart()
                .apply {
                    data = lineData
                }
        },
        update = { update() }
    )
}

fun LineChart.setupLineChart(): LineChart = this.apply {
    setTouchEnabled(true)
    isDragEnabled = true
    setScaleEnabled(true)
    setPinchZoom(true)
    description.isEnabled = false

    // set up x-axis
    xAxis.apply {
        position = XAxis.XAxisPosition.BOTTOM
        // axisMinimum = -10f
        // axisMaximum = 10f
    }

    // set up y-axis
    axisLeft.apply {
        // axisMinimum = -5f
        // axisMaximum = 5f
        setDrawGridLines(true)
    }

    axisRight.isEnabled = false
}
