package com.payment.dashboard.railandbottomdemo

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.payment.dashboard.R

data class BottomNavigationItem2(
    val label : String ="",
    val icon :  Int = R.drawable.baseline_home_24,
    val route : String = ""
){
   fun bottomNavigationItem2() : List<BottomNavigationItem2>{
       return listOf(
           BottomNavigationItem2(
               label = "Home",
               icon = R.drawable.baseline_home_24,
               route = BottomScreens.HOME.route
           ),
           BottomNavigationItem2(
               label = "Movie",
               icon = R.drawable.baseline_movie_24,
               route = BottomScreens.MOVIE.route
           ),
           BottomNavigationItem2(
               label = "News",
               icon = R.drawable.baseline_newspaper_24,
               route = BottomScreens.NEWS.route
           ),
           BottomNavigationItem2(
               label = "TVShows",
               icon = R.drawable.baseline_tv_24,
               route = BottomScreens.TVSHOW.route
           )
       )
   }
}
