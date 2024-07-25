package com.payment.dashboard.railandbottomdemo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.payment.dashboard.screens.Home
import com.payment.dashboard.screens.Movies
import com.payment.dashboard.screens.News
import com.payment.dashboard.screens.TVShows
import com.payment.dashboard.ui.theme.DashBoardTheme

class HomeActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashBoardTheme {
                val navController: NavHostController = rememberNavController()
                val window = calculateWindowSizeClass(activity = this)
                val compact = window.widthSizeClass == WindowWidthSizeClass.Compact
                var selectedNavigationIndex = 0
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Scaffold(modifier = Modifier.fillMaxSize(),
                        bottomBar = {

                               if(compact){
                                   NavigationBottomBar2(modifier = Modifier,navController)
                               }
                        },
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = BottomScreens.HOME.route,
                            modifier = Modifier.padding(it)
                        ){
                            composable(BottomScreens.HOME.route){
                                var bb = false
                                if(!compact){
                                    bb = true
                                }else if (compact){
                                    bb =false
                                }
                               Home(bb)
                            }
                            composable(BottomScreens.MOVIE.route){
                                  Movies()
                            }
                            composable(BottomScreens.NEWS.route){
                               News()
                            }
                            composable(BottomScreens.TVSHOW.route){
                                 TVShows()
                            }
                        }
                    }
                }
                // Rail
                if (!compact) {
                    NavigationRailBar(modifier = Modifier,navController)

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