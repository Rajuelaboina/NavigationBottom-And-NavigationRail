package com.payment.dashboard.railandbottomdemo

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.payment.dashboard.R


@Composable
fun NavigationBottomBar2(modifier: Modifier.Companion, navController: NavHostController)
{
     val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination


   NavigationBar(
       modifier = modifier,
       containerColor = Color.Transparent,
   ) {

      BottomNavigationItem2().bottomNavigationItem2().forEachIndexed { index, bottomNavigationItem ->

       NavigationBarItem(
           selected = bottomNavigationItem.route == currentRoute?.route,
           label = { Text(text = bottomNavigationItem.label)},
           icon = {
               Icon(painter = painterResource(id = bottomNavigationItem.icon ), contentDescription = bottomNavigationItem.label )
           },
           onClick = {
                       navController.navigate(bottomNavigationItem.route){
                           popUpTo(navController.graph.findStartDestination().id){
                               saveState = true
                           }
                           restoreState = true
                           launchSingleTop = true
                       }

                     },
           colors = NavigationBarItemDefaults.colors(
               selectedTextColor = colorResource(id = R.color.purple_700),
               selectedIconColor = Color.White,
               unselectedIconColor = Color.Black,
               unselectedTextColor = Color.Black,
               indicatorColor = colorResource(id = R.color.purple_700)
           ),
       )
      }
   }


}