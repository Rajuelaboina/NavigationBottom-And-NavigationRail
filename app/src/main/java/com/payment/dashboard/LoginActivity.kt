package com.payment.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.payment.dashboard.database.ResidentDataBase
import com.payment.dashboard.database.UserData
import com.payment.dashboard.ui.theme.DashBoardTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashBoardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }





@Composable
 fun LoginScreen(modifier: Modifier) {
     var userName by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")}
    var isPasswordVisible by remember { mutableStateOf(false) }
    var isErroVisible by remember { mutableStateOf(false) }
    var isPasswordErroVisible by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val activity = (LocalContext.current as? Activity)
     Box(modifier = Modifier
         .fillMaxSize()
         .padding(top = 250.dp)) {
         Column(modifier = Modifier
             .fillMaxSize()
             .align(Alignment.Center),
             horizontalAlignment = Alignment.CenterHorizontally
             ) {
             val focusManager = LocalFocusManager.current
             OutlinedTextField(value = userName ,
                 onValueChange = {userName = it
                     isErroVisible = false},
                 label = { Text(text = "username")},
                 placeholder = { Text(text = "Enter UserName")},
                 keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                 keyboardActions = KeyboardActions(
                     onNext = { focusManager.moveFocus(FocusDirection.Next) }
                 ),
                 trailingIcon = {
                     Icon(imageVector = Icons.Default.Person, contentDescription = "Username")
                 },
                 singleLine = true,
                  isError  = isErroVisible,
                 colors = TextFieldDefaults.colors(
                     focusedIndicatorColor = colorResource(id = R.color.purple_700),
                     unfocusedIndicatorColor = Color.Black,
                     errorIndicatorColor = Color.Red,
                 )

             )
             OutlinedTextField(value = password ,
                 onValueChange = {
                     isPasswordErroVisible = false
                     password = it},
                 label = { Text(text = "password")},
                 placeholder = { Text(text = "Enter Password")},
                 keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                 keyboardActions = KeyboardActions(
                     onNext = { focusManager.moveFocus(FocusDirection.Next) }
                 ),
                 trailingIcon = {
                     IconButton(onClick = {  isPasswordVisible = !isPasswordVisible }) {
                         Icon(
                          if (isPasswordVisible) painterResource(id = R.drawable.ic_visibility_black_18dp) else painterResource(id = R.drawable.ic_visibility_off_black_18dp),
                         contentDescription = "",
                         tint = MaterialTheme.colorScheme.primary
                         )
                     }
                    // Icon(Icons.Default.Person, contentDescription = "password")
                 },
                 singleLine = true,
                 visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                 isError  = isPasswordErroVisible,
                 colors = TextFieldDefaults.colors(
                     focusedIndicatorColor = colorResource(id = R.color.purple_700),
                     unfocusedIndicatorColor = Color.Black,
                     errorIndicatorColor = Color.Red,
                 )
             )
             Button(contentPadding = ButtonDefaults.ContentPadding,
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, color = Color.LightGray),
                    elevation = ButtonDefaults.buttonElevation(5.dp),

                    onClick = {

                             if (userName.isNotEmpty() && password.isNotEmpty()) {
                                 scope.launch(Dispatchers.IO) {
                                     ResidentDataBase.getInstance(context).residentDao().loginInsert(
                                         UserData(0,userName, password)
                                     )

                                 }
                                /* val viewModel = MainViewModal()
                                 scope.launch(Dispatchers.IO)  {
                                     ResidentDataBase.getInstance(context).residentDao().insertResident(
                                         ResidentCompleteSearchItem(
                                             1982, 202321090,
                                             "MD"," Ozge Aktas, M.D.",
                                         "3",
                                      "",
                                     "",
                                     "",
                                      null,
                                    null,
                                      "",
                                     "",
                                      "",
                                     "",
                                    "83__0202321090.jpg",
                                     "83__0202321090.jpg",
                                     "AllergyData__20240223.xlsx",
                                    "Date(1708718409703)",
                                     "National Institutes of Health Clinical Center Program",
                                     "Allergy and Immunology",
                                     "Bethesda MD",
                                         )
                                     )
                                 }*/
                                 context.startActivity(Intent(context, MainActivity::class.java))
                             }else if (userName.isEmpty()){
                                 isErroVisible = true
                             }else if (password.isEmpty()){
                                 isPasswordErroVisible = true
                             }
                    }) {
                  Text(text = "Submit")
                 
             }
         }
     }
  // 39400 600 cal
}

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    DashBoardTheme {
     //  LoginScreen(modifier = Modifier)
    }
}