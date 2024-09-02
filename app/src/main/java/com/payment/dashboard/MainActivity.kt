package com.payment.dashboard

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.payment.dashboard.modal.ResidentCompleteSearchItem
import com.payment.dashboard.ui.theme.DashBoardTheme
import com.payment.dashboard.viewmodal.MainViewModal


class MainActivity : ComponentActivity() {

    @SuppressLint("CoroutineCreationDuringComposition")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // val window: Window = this.window
           // window.navigationBarColor = MaterialTheme.colorScheme.primary.toArgb()
            DashBoardTheme {
                //StatusBarColor(color = MaterialTheme.colors.primary)
               Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.primary) {
                   val viewModel = MainViewModal()
                  // val viewModel: MainViewModal by viewModel()
                   var providerName by remember { mutableStateOf("") }
                   var locationName by remember { mutableStateOf("") }
                   var pgyName by remember { mutableStateOf("") }

                   viewModel.getResidentCompleteSearch2("","","")
                   val ll = ArrayList<ResidentCompleteSearchItem>()
                  // ll.addAll(viewModel.residentCompleteSearchListResponse)
                  // Log.e("Home","ll <><>>>>>>: "+ll.size)
                   val scope = rememberCoroutineScope()

                   viewModel.residentCompleteSearchListResponse.forEach {
                       // 24 +15 = 40
                       /*val context = LocalContext.current
                       scope.launch(Dispatchers.IO)  {
                           ResidentDataBase.getInstance(context).residentDao().insertResident(
                               ResidentCompleteSearchItem(
                                   it.ID, it.ProgramID,
                                   it.Location, it.Provider_Name,
                                   it.PGY,it.ClassOf,it.UnderGraduateCollege,
                                   it.MedicalSchool,it.Internship,
                                   it.Major,it.Fellowship,
                                   it.HomeTown,it.MailID,
                                   it.PhoneNo,it.Misc,
                                   it.Photo,it.FileName,
                                   it.TimeStamp,it.ProgramName,
                                   it.Speciality,it.ProgramLocation
                               )
                           )
                       }*/

                       ll.addAll(listOf(it))
                       ll.add(
                           ResidentCompleteSearchItem(
                           it.ID, it.ProgramID,
                           it.Location, it.Provider_Name,
                           it.PGY,it.ClassOf,it.UnderGraduateCollege,
                           it.MedicalSchool,it.Internship,
                           it.Major,it.Fellowship,
                           it.HomeTown,it.MailID,
                           it.PhoneNo,it.Misc,
                           it.Photo,it.FileName,
                           it.TimeStamp,it.ProgramName,
                           it.Speciality,it.ProgramLocation
                           ))


                   }
                       // 5000/3 = 1666
                   // Account num : 5535937559
                 //  IFC CODE : UTIB0005151
                   Log.e("Home","ll <><>>>>>>: "+ll.size)
                   /*val comList by viewModel.list.observeAsState(emptyList())
                   Log.e("comList ><<<<<<<<<<<<<<<","comList: "+comList)
                   Log.e("comList ><<<<<<<<<<<<<<<","comList: "+comList.size)
                   comList.forEach {
                       Log.e("comList ><<<<<<<<<<<<<<<","comList: "+it.Photo)
                   }*/
                  /* LaunchedEffect(Unit) {
                       viewModel.getResidentCompleteSearch2("","","")
                   }*/
                   NavigationDashBoard()
                   // bottom navigation and Rail navigation
                  // val windowSize = calculateWindowSizeClass(this)
                  // JetMainApp(windowSize = windowSize.widthSizeClass, modifier = Modifier)
                   // Broadcast Receiver
                  /* systemBroadCastReceiver(Intent.ACTION_BATTERY_CHANGED){ batteryStatus ->
                       Log.e("BATTERY STATUS","BATTERY STATUS: "+ batteryStatus)
                   }*/

                }
            }
        }
    }
}

@Composable
private fun systemBroadCastReceiver(systemAction: String, onSystemEvent: (Any) -> Int) {
    val context = LocalContext.current

    // Safely use the latest onSystemEvent lambda passed to the function
    val currentOnSystemEvent by rememberUpdatedState(onSystemEvent)

    // If either context or systemAction changes, unregister and register again
    DisposableEffect(context, systemAction) {
        val intentFilter = IntentFilter(systemAction)
        val broadcast = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val level = intent!!.getIntExtra("level", 0)
                val status: Int = intent!!.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
                val isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                        status == BatteryManager.BATTERY_STATUS_FULL
                val str = ""+isCharging+"/n"+status+"/n"+level

                currentOnSystemEvent(str)
            }

            private fun currentOnSystemEvent(level: Int) {
                TODO("Not yet implemented")
            }
        }

        context.registerReceiver(broadcast, intentFilter)

        // When the effect leaves the Composition, remove the callback
        onDispose {
            context.unregisterReceiver(broadcast)
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NavigationDashBoard()
        }
    }
}