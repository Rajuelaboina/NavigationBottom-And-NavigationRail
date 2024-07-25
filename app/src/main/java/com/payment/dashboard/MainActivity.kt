package com.payment.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.payment.dashboard.screens.Home
import com.payment.dashboard.ui.theme.DashBoardTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           // val window: Window = this.window
           // window.navigationBarColor = MaterialTheme.colorScheme.primary.toArgb()
            DashBoardTheme {
                //StatusBarColor(color = MaterialTheme.colors.primary)
               Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
                  NavigationDashBoard()

                   // bottom navigation and Rail navigation
                  // val windowSize = calculateWindowSizeClass(this)
                  // JetMainApp(windowSize = windowSize.widthSizeClass, modifier = Modifier)

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
        NavigationDashBoard()
    }
}