package com.payment.dashboard.viewpager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.viewpager.ViewPagerItem
import com.example.viewpager.viewPagerDotsIndicator
import com.payment.dashboard.R
import com.payment.dashboard.ui.theme.DashBoardTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

class ViewPagerActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashBoardTheme {
                Surface {
                    val images = listOf(
                        R.drawable.ic_launcher_background,
                        R.drawable.ic_launcher_background,
                        R.drawable.ic_launcher_background,
                        R.drawable.ic_launcher_background,
                        R.drawable.ic_launcher_background,
                    )
                 //   val pagerState = rememberPagerState(initialPage = 0,pageCount = {5})
                    // Used Int.MAX_VALUE for infinity scroll
                    val pageCount = Int.MAX_VALUE
                    // The actual view pager size (for the HorizontalPagerIndicator)
                    val realSize = images.size
                    // Start from the middle in order to the infinity scroll for both sides
                    val middlePage = pageCount / 2
                    // Init the PagerState with a very large number and make it always start from the first item of the real list
                    val vv = middlePage - (middlePage % realSize)
                    val pagerState = rememberPagerState(initialPage = vv, pageCount ={images.size})
                    val isDraggedState = pagerState.interactionSource.collectIsDraggedAsState()
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)) {
                        HorizontalPager(state = pagerState ) { page->
                            ViewPagerItem(page = page, Color.White,images)
                        }
                        viewPagerDotsIndicator(
                            Modifier
                                .fillMaxWidth()
                                .align(Alignment.BottomCenter),
                            pagesCount = images.size,
                            currentPageIteration = pagerState.currentPage
                        )
                    }
                    // Start auto-scroll effect
                    LaunchedEffect(isDraggedState) {
                        // convert compose state into flow
                        snapshotFlow { isDraggedState.value }
                            .collectLatest { isDragged ->
                                // if not isDragged start slide animation
                                if (!isDragged) {
                                    // infinity loop
                                    while (true) {
                                        // duration before each scroll animation
                                        delay(1_000L)
                                        runCatching {
                                            pagerState.animateScrollToPage(pagerState.currentPage.inc() % pagerState.pageCount)
                                        }
                                    }
                                }
                            }
                    }
                }
            }
        }
    }
}

