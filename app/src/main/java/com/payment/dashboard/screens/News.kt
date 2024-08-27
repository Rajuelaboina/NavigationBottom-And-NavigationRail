package com.payment.dashboard.screens

import android.util.Log
import android.widget.NumberPicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.StreetViewPanoramaOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.streetview.StreetView
import com.google.maps.android.ktx.MapsExperimentalFeature
import com.payment.dashboard.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun News() {
    Column {
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
        MapScreen2()

    }
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
