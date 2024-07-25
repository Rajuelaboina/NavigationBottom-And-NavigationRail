package com.payment.dashboard

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavigationRailSample(navController: NavHostController) {

    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination
    NavigationRail {
        BottomNavigationItem().bottomNavigationItems()
            .forEachIndexed { index, navigationItem ->
              NavigationRailItem(
                  selected = navigationItem.route == currentRoute?.route,
                  label = { Text(text = navigationItem.label)},
                  icon = {
                      Icon(painter = painterResource(id = navigationItem.icon), contentDescription = navigationItem.label)
                      
                  },
                  onClick = {
                      navController.navigate(navigationItem.route)
                  },
              )

            }
    }
}