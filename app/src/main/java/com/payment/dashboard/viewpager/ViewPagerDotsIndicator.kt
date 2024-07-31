package com.example.viewpager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun viewPagerDotsIndicator( modifier: Modifier = Modifier, pagesCount: Int, currentPageIteration: Int) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        repeat(pagesCount){ iteration ->
            val color =
                if (currentPageIteration == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(15.dp)
            )

        }
    }
}