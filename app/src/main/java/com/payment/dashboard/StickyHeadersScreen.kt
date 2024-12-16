package com.payment.dashboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeadersScreen() {

    val sectionedItems = ArrayList<SectionedListItem>()
    for (section in 1..5){
        val itemList = ArrayList<Item>()
        for (item in 1..3){

            itemList.add(Item("name $item ", "$item Description"))
        }
        sectionedItems.add(SectionedListItem("Section: $section", itemList))
    }

    SectionedStickyRecyclerView(
        items = sectionedItems,
        modifier = Modifier.fillMaxSize()
    )
    /*val sections = listOf("A","B","C")

    LazyColumn(modifier = Modifier.fillMaxWidth(),) {
        sections.forEach { section ->

             stickyHeader {
                 Column(modifier = Modifier
                     .height(40.dp)
                     .fillMaxWidth()
                     .background(Color.LightGray)
                 ) {

                     Text(
                         text = section,
                         modifier = Modifier.fillMaxWidth(),
                         style = MaterialTheme.typography.subtitle2,
                         textAlign = TextAlign.Center,
                         color = Color.Red
                     )
                 }
             }
            items(100){  item->
                Text(text = "Some item $item",modifier = Modifier.fillMaxWidth(),)

            }

        }
    }*/
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SectionedStickyRecyclerView(
    items: List<SectionedListItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items.forEachIndexed { index, sectionedItem ->
            stickyHeader {
                Card(
                    modifier = modifier
                        .padding(start = 1.dp, end = 1.dp)
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(1.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 3.dp
                    )
                ){
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)) {
                        Text(modifier = Modifier
                            .padding(horizontal = 8.dp, vertical = 5.dp),
                            text = sectionedItem.sectionTitle,
                            style = TextStyle(color = Color.Black, fontSize = 16.sp)
                        )
                    }
                }
            }
            items(sectionedItem.items) { item ->
                val painter = painterResource(id = R.drawable.capture)
                val contentDescription = "Content description"
                Text(text = item.name, color = Color.Blue,
                    style = MaterialTheme.typography.subtitle2,
                    textAlign = TextAlign.Center,)
                Image(painter = painter , contentDescription = contentDescription)
            }
        }
    }
}
//Section list
data class SectionedListItem(
    val sectionTitle: String,
    val items: List<Item>
)

//List in each section
data class Item(
    val name: String,
    val description: String
)