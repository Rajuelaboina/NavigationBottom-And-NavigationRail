package com.payment.dashboard

data class BottomNavigationItem(
  val label : String ="",
   val icon :  Int = R.drawable.baseline_home_24,
    val route : String = ""
) {
   fun bottomNavigationItems() : List<BottomNavigationItem>{

       return listOf(
              BottomNavigationItem(
               label = "movies",
               icon = R.drawable.baseline_movie_24,
               route = BottomScreens.MOVIES.route
              ),
           BottomNavigationItem(
               label = "news",
               icon = R.drawable.baseline_newspaper_24,
               route = BottomScreens.NEWS.route
           ),
           BottomNavigationItem(
               label = "tvshows",
               icon = R.drawable.baseline_tv_24,
               route = BottomScreens.TVSHOWS.route
           ),
       )
   }

}