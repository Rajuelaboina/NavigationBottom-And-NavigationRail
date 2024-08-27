package com.payment.dashboard

sealed class BottomScreens(val route:String) {
    object MOVIES : BottomScreens("movies")
    object NEWS : BottomScreens("news")
    object TVSHOWS : BottomScreens("tvshows")
   // object PAGERVIEW : BottomScreens("pagerview")
}