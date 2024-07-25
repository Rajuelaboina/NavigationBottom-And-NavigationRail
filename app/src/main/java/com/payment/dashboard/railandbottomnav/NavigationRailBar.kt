package com.payment.dashboard.railandbottomdemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.material.NavigationRail
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemColors
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.payment.dashboard.R

@Composable
fun NavigationRailBar(
    modifier: Modifier.Companion,
    navController: NavHostController,
 ) {
       val navBackStackEntry by navController.currentBackStackEntryAsState()
       val currentRoute = navBackStackEntry?.destination
    NavigationRail(
        header = {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "menu"
                )
            }
            FloatingActionButton(
                onClick = { },
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add"
                )
            }
        },
        modifier = Modifier
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .offset(x = (-1).dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = 12.dp,
                alignment = Alignment.Bottom
            ),
            modifier = Modifier.fillMaxHeight()
        ) {
             BottomNavigationItem2().bottomNavigationItem2().forEachIndexed { index, bottomNavigationItem2 ->
                 //selected = bottomNavigationItem.route == currentRoute?.route,
                 NavigationRailItem(
                     selected =  bottomNavigationItem2.route == currentRoute?.route,
                     icon = { 
                         Icon(painter = painterResource(id = bottomNavigationItem2.icon) , contentDescription = bottomNavigationItem2.label)
                     },
                     label = { Text(text = bottomNavigationItem2.label)},
                     onClick = {
                         navController.navigate(bottomNavigationItem2.route){
                             popUpTo(navController.graph.findStartDestination().id){
                                 saveState =true
                             }
                             launchSingleTop = true
                             restoreState = true
                         }
                     },
                     colors = NavigationRailItemDefaults.colors(
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

}