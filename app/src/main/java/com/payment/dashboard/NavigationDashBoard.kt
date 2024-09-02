package com.payment.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Badge
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BadgedBox
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
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

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDashBoard(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: AllDestinations.HOME
    val navigationActions = remember(navController) { AppNavigationActions(navController) }
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    var openDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val activity = (LocalContext.current as? Activity)

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
                       containerColor = colorResource(id = R.color.topBar),
                       titleContentColor = MaterialTheme.colorScheme.onPrimary,
                       navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                       actionIconContentColor = MaterialTheme.colorScheme.onSecondary
                   ),
                   actions = {
                       IconButton(onClick = {
                           openDialog = true
                          /* context.startActivity(Intent(context,LoginActivity::class.java))
                           activity?.finish()*/

                       }) {
                           Icon(painterResource(id = R.drawable.baseline_logout_24), contentDescription = "LogOut" )
                       }
                       /*IconButton(onClick = {  }) {
                           Icon(painterResource(id = R.drawable.baseline_email_24), contentDescription = "LogOut" )
                       }
                       IconButton(onClick = {  }) {
                           Icon(painterResource(id = R.drawable.baseline_message_24), contentDescription = "LogOut" )
                       }*/
                       BadgedBox(badge = {
                           Badge(
                               modifier = Modifier.shadow(elevation = 2.dp, shape = RoundedCornerShape(5.dp)),
                               contentColor = Color.Red,
                               backgroundColor = Color.White
                           ){
                               Text(text = "10", fontSize = 10.sp, color = Color.Red)
                           }
                       }) {
                           Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "Email",
                               modifier = Modifier.size(40.dp))

                       }
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

                   Home(navController)
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

               /*composable(BottomScreens.PAGERVIEW.route){
                   PagerScreen()
               }*/


           }


       }

        if (openDialog) {
            AlertDialog(onDismissRequest = {
                openDialog = false
            },
              /*  title = { Text(text = "LogOut", style = MaterialTheme.typography.titleLarge, color = colorResource(
                    id = R.color.topBar)
                )},*/
                text = { Text(text = "Do you Exit the App",style = MaterialTheme.typography.titleMedium,
                    color = colorResource(id = R.color.topBar)) },

                confirmButton = {
                    Button(onClick = {
                         context.startActivity(Intent(context,LoginActivity::class.java))
                          activity?.finish()
                    }, shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(text = "Yes", color = Color.White)
                    }
                },
                dismissButton = {
                    Button(onClick = { openDialog = false }, shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(text = "Cancel", color = Color.White)
                    }

                },
                shape =  RoundedCornerShape(16.dp),
                properties = DialogProperties(),

            )
        }
    }


}
