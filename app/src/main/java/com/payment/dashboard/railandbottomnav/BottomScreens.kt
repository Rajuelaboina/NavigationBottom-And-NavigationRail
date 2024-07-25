package com.payment.dashboard.railandbottomdemo

sealed class BottomScreens( val  route: String ){
    object HOME : BottomScreens("Home")
    object MOVIE : BottomScreens("Movie")
    object NEWS : BottomScreens("News")
    object TVSHOW : BottomScreens("TVShows")
}
