package com.example.viewpager

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ViewPagerItem(page: Int, preferredBackground: Color? = null, images: List<Int>) {
  //  val backgroundColor = preferredBackground ?: getBackgroundColorForPage(page)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = images[page]), contentDescription = "image",
            modifier = Modifier.fillMaxWidth().height(150.dp), contentScale = ContentScale.FillWidth)
        Text(text = "Page: ${page + 1}")
    }
}

@Preview
@Composable
private fun ViewPagerItemPreview() {
    //ViewPagerItem(page = 0, images = images)
}