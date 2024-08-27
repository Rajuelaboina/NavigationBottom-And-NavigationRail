package com.example.viewpager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.payment.dashboard.R
import com.payment.dashboard.modal.ResidentCompleteSearchItem
import com.payment.dashboard.utility.getImgUrl


@Composable
fun ViewPagerItem(page: Int, preferredBackground: Color? = null, images: List<ResidentCompleteSearchItem>) {
  //  val backgroundColor = preferredBackground ?: getBackgroundColorForPage(page)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(colorResource(id = R.color.sb)),

        //contentAlignment = Alignment.Center
    ) {
       /* Image(painter = painterResource(id = images[page]), contentDescription = "image",
            modifier = Modifier.fillMaxWidth().height(150.dp), contentScale = ContentScale.FillWidth)*/
        val imageUrl = getImgUrl() + images[page].Photo
        AsyncImage(
            model = imageUrl,
            contentDescription = "Resident user Image",
            placeholder = painterResource(id = R.drawable.doctor),
            error = painterResource(id = R.drawable.doctor),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.CenterHorizontally)
                .clip(shape = CutCornerShape(10.dp)),
        )
        //Text(text = "Page: ${page + 1}" + images[page].Provider_Name)
        Text(text = images[page].Provider_Name.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}

@Preview
@Composable
private fun ViewPagerItemPreview() {
    //ViewPagerItem(page = 0, images = images)
}