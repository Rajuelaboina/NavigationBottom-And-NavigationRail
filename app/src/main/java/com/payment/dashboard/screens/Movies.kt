package com.payment.dashboard.screens

import android.os.Build
import android.os.Message
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.payment.dashboard.GroupScreen
import com.payment.dashboard.HomeScreen
import com.payment.dashboard.MessageScreen
import com.payment.dashboard.NotificationScreen
import com.payment.dashboard.ProfileScreen
import com.payment.dashboard.R
import kotlinx.coroutines.launch
import java.security.MessageDigestSpi

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Movies() {
     val tabData = getTabList()
    val pagerState = rememberPagerState(pageCount = {tabData.size})
    
    Column(modifier = Modifier.fillMaxSize()) {
             TabLayout(tabData , pagerState)
             TabContent(tabData , pagerState)
    }
}
@Composable
fun  TabLayout(tabData: List<Pair<String, ImageVector>>, pagerState: PagerState) {
           val scope = rememberCoroutineScope()
    ScrollableTabRow(selectedTabIndex = pagerState.currentPage,
               divider = {
                   Spacer(modifier = Modifier.height(5.dp))
               },
               indicator = { tabPositions ->
                   SecondaryIndicator(
                       modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                       height = 5.dp,
                       color = Color.White
                   )
               },
               modifier = Modifier
                   .fillMaxWidth()
                   .wrapContentHeight(),
              backgroundColor = Color(0xFF6650a4),
            contentColor = Color.White
           ) {
               tabData.forEachIndexed{ index, pair ->
                   Tab(selected = pagerState.currentPage == index,
                       onClick = {
                          scope.launch {
                              pagerState.animateScrollToPage(index)
                          }
                     },
                      icon = {
                          Icon(imageVector = pair.second,
                              contentDescription = null,
                              tint = Color.White)
                      },
                     text = { Text(text = pair.first)}
                   )
               }
           }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TabContent(tabData: List<Pair<String, ImageVector>>, pagerState: PagerState) {
           HorizontalPager(state = pagerState) { index ->
               when(index){
                   0 -> {
                       MessageScreen()
                   }
                   1 -> {
                       GroupScreen()
                   }
                   2 -> {
                       HomeScreen()
                   }
                   3 -> {
                       NotificationScreen()
                   }
                   4 -> {
                       ProfileScreen()
                   }
               }
           }
}
private fun getTabList(): List<Pair<String, ImageVector>> {
    return listOf(
        "Home" to Icons.Default.Home,
        "Message" to Icons.Default.Email,
        "Group" to Icons.Default.Build,
        "Notification" to Icons.Default.Notifications,
        "Profile" to Icons.Default.Person,
    )
}
/*
Card(
modifier = Modifier.padding(10.dp)
.pointerInput(Unit) {
    detectTapGestures(
        onPress = {

            //start
            val released = try {
                tryAwaitRelease()
            } catch (c: CancellationException) {
                false
            }
            if (released) {
                //ACTION_UP

            } else {
                //CANCELED

            }
        },
    )
}
.shadow(
elevation = 12.dp,
shape = RoundedCornerShape(12.dp),
clip = true,
ambientColor = MaterialTheme.colorScheme.primary,
spotColor = MaterialTheme.colorScheme.primary
),
shape = RoundedCornerShape(12 / 2),
colors = CardDefaults.cardColors(
containerColor = backgroundColor,
),
) {
    Row(
        modifier = Modifier.fillMaxWidth().height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

    }
}*/
