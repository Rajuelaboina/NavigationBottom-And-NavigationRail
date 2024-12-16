package com.payment.dashboard.screens

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.MarqueeAnimationMode
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.focusable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.maps.StreetViewPanoramaOptions
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.streetview.StreetView
import com.google.maps.android.ktx.MapsExperimentalFeature
import com.payment.dashboard.R
import com.payment.dashboard.SnackBarDeledate
import com.payment.dashboard.SnackbarState
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun News() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    var clickCount by remember { mutableStateOf(0) }

    val snackBarDeledate = SnackBarDeledate()
    val  snackbarState: SnackbarState = SnackbarState.DEFAULT

    Scaffold( modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {

            ExtendedFloatingActionButton(
                onClick = {
                    // show snackbar as a suspend function
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            "Snackbar # ${++clickCount}",
                            actionLabel = "Testing"
                        )
                       /* snackBarDeledate.showSnackbar(
                            snackbarState,
                            "welcome",
                            "testing",
                             "actionLabel",
                                true,
                               SnackbarDuration.Long,


                        )*/
                    }
                }
            ) { Text("Show snackbar") }
        },
        content = { innerPadding ->
            val focusRequester = remember { FocusRequester() }
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Test  content dfsdfsdfsdsdfsdfssdfsdfdfdf fdsfsdf",
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)

                        .basicMarquee()
                )
                Text(
                    text = "Body contentv fds bbbbbb bbb ccccccccccccccccc aaaaaaaaaaaaaa",
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        //.basicMarquee( )
                        //.basicMarquee(animationMode = MarqueeAnimationMode.WhileFocused)
                        .basicMarquee(animationMode = MarqueeAnimationMode.Immediately)
                        .focusRequester(focusRequester)
                        .focusable()
                        .padding(0.dp),
                    maxLines = 1
                    //.wrapContentSize()
                )
               Image(painter = painterResource(id = R.drawable.img), contentDescription = "",
                   modifier = Modifier.basicMarquee().padding(20.dp).fillMaxWidth())

                val scrollState = rememberScrollState()
                var shouldAnimate by remember {
                    mutableStateOf(true)
                }
                var shouldAnimated = false
                LaunchedEffect(key1 = shouldAnimated){
                    scrollState.animateScrollTo(
                        scrollState.maxValue,
                        animationSpec = tween(10000, 200, easing = CubicBezierEasing(0f,0f,0f,0f))
                    )
                    scrollState.scrollTo(0)
                    shouldAnimated = !shouldAnimated
                }
                Text(
                    text = "AAAAAnnnnnnnnnnnnnnnnnnnncxczxcccccccccccccccccccccccccccccccccccccccccccccccccccccccxczzzzzzzzzzznnnnn",
                    color = Color.Black,
                    fontSize = 20.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.horizontalScroll(scrollState, true)
                )

                Button(modifier = Modifier.padding(innerPadding) , onClick = {
                    scope.launch {

                        /*scaffoldState.snackbarHostState.showSnackbar(
                            message = "This is your message",
                            actionLabel = "Do something"
                        )*/
                        snackbarHostState.showSnackbar(
                            "Snackbar # ${++clickCount}",
                            actionLabel = "Do something",
                            duration = SnackbarDuration.Short,
                            withDismissAction = true

                        )
                    }
                }) {
                    Text(text = "Snackbar")
                }
            }

        }
    )


    //Column {
       /* var status by remember { mutableStateOf(false) }
        var statusValue by remember { mutableStateOf(0) }
        val sheetState = rememberModalBottomSheetState()
        val snackbarHostState = remember { SnackbarHostState() }
        var txt = "This is news screen"
        Text(text = txt, Modifier.align(alignment = Alignment.CenterHorizontally))

        TextButton(onClick = { *//*TODO*//* },
            shape = CutCornerShape(10.dp),
            border = BorderStroke(1.dp, color = Color.Green),
            contentPadding = PaddingValues(20.dp)
        ) {
              Text(text = "ButtonText")
        }
        AndroidView( modifier = Modifier.width(250.dp),
            factory = { context->
            NumberPicker(context).apply {
                setOnValueChangedListener { picker, oldVal, newVal ->
                    //onValueChange(i)
                    status = true
                    statusValue = newVal
                    Log.d("TAG","oldValue: $oldVal"+"\n"+"newValue: $newVal")
                }
                minValue = 0
                maxValue = 12
           }
        })
        if (status){
            txt = statusValue.toString()
          //   snackbarHostState.showSnackbar("")
        }
        Text(text = txt, Modifier.align(alignment = Alignment.CenterHorizontally))
        val monthArray = arrayOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")
        AndroidView( modifier = Modifier.width(250.dp),
            factory = { context->
                NumberPicker(context).apply {
                    setOnValueChangedListener { picker, oldVal, newVal ->
                        //onValueChange(i)
                        // 50 - 15 = 35 -15 = 20 -9 = 11-9=2
                        status = true
                        statusValue = newVal
                        Log.d("TAG","oldValue: $oldVal"+"\n"+"newValue: $newVal")

                    }
                    minValue = 0
                    maxValue = monthArray.size-1

                }


           })

      *//*  ModalBottomSheet(
            onDismissRequest = { *//**//*TODO*//**//* },
            sheetState = sheetState,
            dragHandle = { BottomSheetDefaults.DragHandle() },
        ) {
            
        }*//*
        *//*BottomSheetScaffold(sheetPeekHeight = 120.dp,
            sheetDragHandle = {},
            sheetContent = {}) {
            
        }*//*
        var txtValue by remember {mutableStateOf("")}
        TextField(
            value = txtValue ,
            onValueChange = { txtValue = it },
            label = { Text(text = "Username")},
            placeholder = { Text(text = "Enter UserName")},
        )
        OutlinedTextField(value = txtValue,
            onValueChange ={txtValue = it},
            label = { Text(text = "Password")},
            placeholder = { Text(text = "Enter password")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                Icon(painterResource(id = R.drawable.baseline_photo_camera_24), contentDescription = "null" )
            },



        )*/
        //MapScreen2()

 //   }
}

@OptIn(MapsExperimentalFeature::class)
@Composable
fun MapScreen2() {
    val atasehir = LatLng(40.9971, 29.1007)

    StreetView(
        streetViewPanoramaOptionsFactory = {
            StreetViewPanoramaOptions().position(atasehir)
        },
        isPanningGesturesEnabled = true,
        isStreetNamesEnabled = true,
        isUserNavigationEnabled = true,
        isZoomGesturesEnabled = true
    )
}
