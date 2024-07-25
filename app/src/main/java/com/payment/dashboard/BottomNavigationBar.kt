package com.payment.dashboard

import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigationBar(
    modifier: Modifier,
    navController: NavHostController
) {
   val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        modifier = modifier,
        containerColor = Color.Transparent,
    ) {
             BottomNavigationItem().bottomNavigationItems().forEachIndexed{ index, bottomNavigationItem ->
              NavigationBarItem(
                  selected = bottomNavigationItem.route == currentDestination?.route ,
                  label = { Text(text = bottomNavigationItem.label)},
                  icon = {
                         Icon(painter = painterResource(id = bottomNavigationItem.icon) , contentDescription = bottomNavigationItem.label )
                  },
                  onClick = {
                      navController.navigate(bottomNavigationItem.route) {
                          popUpTo(navController.graph.findStartDestination().id) {
                              saveState = true
                          }
                          launchSingleTop = true
                          restoreState = true
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
}  // 34-46 = 12