package com.payment.dashboard

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.NavigationRail
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.payment.dashboard.screens.Emails
import com.payment.dashboard.screens.Home
import com.payment.dashboard.screens.Messages
import com.payment.dashboard.screens.Movies
import com.payment.dashboard.screens.News
import com.payment.dashboard.screens.TVShows
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDashBoard2(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: AllDestinations.HOME
    val navigationActions = remember(navController) { AppNavigationActions(navController) }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()


    ModalNavigationDrawer(
        drawerContent =
        {
            AppDrawer(
             route = currentRoute,
             navigateToHome = {navigationActions.navigateToHome()},
             navigateToEmails = {navigationActions.navigateToEmails()},
             navigateToMessages = {navigationActions.navigateToMessages()},
             closeDrawer = {coroutineScope.launch { drawerState.close() }}
            )
        }, drawerState = drawerState, modifier = modifier.fillMaxSize(),
    ){
       Scaffold(
           topBar = {
               val context = LocalContext.current
               TopAppBar(
                   scrollBehavior = scrollBehavior ,
                   title = { Text(text = currentRoute) },
                   //modifier = modifier.fillMaxWidth(),
                   navigationIcon = {
                       IconButton(onClick = {
                           coroutineScope.launch { drawerState.open() }
                       }, content = {
                           Icon(painterResource(id = R.drawable.baseline_menu_24), contentDescription = null)
                       } )

                   },
                   colors = TopAppBarDefaults.topAppBarColors(
                       containerColor = MaterialTheme.colorScheme.primary,
                       titleContentColor = MaterialTheme.colorScheme.onPrimary,
                       navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                       actionIconContentColor = MaterialTheme.colorScheme.onSecondary
                   ),
                   actions = {
                       IconButton(onClick = {  }) {
                           Icon(painterResource(id = R.drawable.baseline_logout_24), contentDescription = "LogOut" )
                       }
                       /*IconButton(onClick = {  }) {
                           Icon(painterResource(id = R.drawable.baseline_email_24), contentDescription = "LogOut" )
                       }
                       IconButton(onClick = {  }) {
                           Icon(painterResource(id = R.drawable.baseline_message_24), contentDescription = "LogOut" )
                       }*/
                   },
               )
           },
           bottomBar = {
              BottomNavigationBar(modifier = modifier,navController)
           },

           modifier = modifier.fillMaxSize()

       )
       {
           NavHost(
               navController = navController,
               startDestination = AllDestinations.HOME,
               modifier = Modifier.padding(it))
           {
               composable(AllDestinations.HOME){
                 Home()
               }
               composable(AllDestinations.EMAILS){
                   Emails()
               }
               composable(AllDestinations.MESSAGES){
                   Messages()
               }
               composable(BottomScreens.MOVIES.route){
                   Movies()
               }
               composable(BottomScreens.NEWS.route){
                   News()
               }
               composable(BottomScreens.TVSHOWS.route){
                    TVShows()
               }

           }


       }
    }


}
