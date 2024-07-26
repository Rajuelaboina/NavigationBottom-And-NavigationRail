package com.payment.dashboard.railandbottomdemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.payment.dashboard.NavigationDashBoard
import com.payment.dashboard.R
import com.payment.dashboard.screens.Home
import com.payment.dashboard.screens.Movies
import com.payment.dashboard.screens.News
import com.payment.dashboard.screens.TVShows
import com.payment.dashboard.ui.theme.DashBoardTheme
import kotlinx.coroutines.launch

class HomeActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashBoardTheme {
                val navController: NavHostController = rememberNavController()
                //navController.previousBackStackEntry
                val window = calculateWindowSizeClass(activity = this)
                val compact = window.widthSizeClass == WindowWidthSizeClass.Compact
                val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
                val coroutineScope = rememberCoroutineScope()

                val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
                val topBarState = rememberSaveable { (mutableStateOf(true)) }
                var showMenu by remember { mutableStateOf(false) }
                var isClicked by remember {  mutableStateOf(false) }

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        modifier = Modifier,
                        floatingActionButtonPosition = FabPosition.End,
                       // isFloatingActionButtonDocked = true,
                        floatingActionButton = {
                           FloatingActionButton(
                                //modifier = Modifier.padding(0.dp),
                                shape = CutCornerShape(10.dp),
                               backgroundColor = colorResource(id = R.color.purple_200),
                               elevation = FloatingActionButtonDefaults.elevation(10.dp),
                                onClick = {
                                    isClicked = true
                                    //NavigationDashBoard()
                                },
                                //containerColor = Color.LightGray
                               contentColor = Color.White
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_photo_camera_24),
                                    contentDescription = "Add icon"
                                )
                            }

                        },
                        topBar = {
                            if (topBarState.value){
                               // CenterAlignedTopAppBar(title = { /*TODO*/ })
                                TopAppBar(
                                    scrollBehavior = scrollBehavior,
                                    title = { Text(text = stringResource(id = R.string.app_name)) },
                                   /* navigationIcon = {
                                        IconButton(onClick = {
                                            coroutineScope.launch {  }
                                        },
                                            content = {
                                                Icon(painter = painterResource(id = R.drawable.baseline_menu_24) , contentDescription = null )
                                            }
                                        )
                                    },*/
                                    /*colors = TopAppBarDefaults.topAppBarColors(
                                        containerColor = MaterialTheme.colorScheme.background,
                                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                                        navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
                                        actionIconContentColor = MaterialTheme.colorScheme.onBackground
                                    ),*/
                                    colors = TopAppBarDefaults.topAppBarColors(
                                        containerColor = colorResource(id = R.color.purple_200),
                                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                                        actionIconContentColor = MaterialTheme.colorScheme.onPrimary
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
                                        IconButton(onClick = { showMenu = !showMenu }) {
                                            Icon(Icons.Default.MoreVert, contentDescription = "More")
                                        }
                                        DropdownMenu(
                                            expanded = showMenu ,
                                            onDismissRequest = { showMenu = false },
                                            modifier = Modifier.background(color = Color.White)
                                        ) {
                                            DropdownMenuItem(onClick = { showMenu = false  }) {
                                                Icon(painter = painterResource(id = R.drawable.baseline_email_24) , contentDescription = "Email")
                                            }
                                            DropdownMenuItem(onClick = { showMenu = false  }) {
                                                Icon(painter = painterResource(id = R.drawable.baseline_movie_24) , contentDescription = "Email")
                                            }
                                            DropdownMenuItem(onClick = { showMenu = false  }) {
                                                Icon(painter = painterResource(id = R.drawable.baseline_message_24) , contentDescription = "Email")
                                            }

                                        }


                                    },

                                    )
                            }

                        },
                        bottomBar = {

                            if (compact) {
                                NavigationBottomBar2(modifier = Modifier, navController)
                            }
                        },
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = BottomScreens.HOME.route,
                            modifier = Modifier.padding(it)
                        ) {
                            composable(BottomScreens.HOME.route) {
                                var bb = false
                                if (!compact) {
                                    bb = true
                                } else if (compact) {
                                    bb = false
                                }
                                Home()
                            }
                            composable(BottomScreens.MOVIE.route) {
                                Movies()
                            }
                            composable(BottomScreens.NEWS.route) {
                                News()
                            }
                            composable(BottomScreens.TVSHOW.route) {
                                TVShows()
                            }
                        }
                    }
                }
                // Rail
                if (!compact) {
                     topBarState.value = false
                    NavigationRailBar(modifier = Modifier, navController)

                }
                if(isClicked){
                    NavigationDashBoard()
                }
            }
        }
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DashBoardTheme {
        Greeting("Android")
    }
}