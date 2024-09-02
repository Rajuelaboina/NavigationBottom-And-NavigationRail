package com.payment.dashboard

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.TextField
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MessageScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    Column {
        CenterText(text = "Message")
        scope.launch(Dispatchers.IO) {

        }

    }
    // 50
}
@Composable
fun GroupScreen() {
    CenterText(text = "Group")
}
@SuppressLint("RememberReturnType")
@Composable
fun HomeScreen() {

    Column(modifier = Modifier.fillMaxSize()) {

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
   // CenterText(text = "Home")
    /*snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    }*/
    /*FloatingActionButton(
        shape = CutCornerShape(10.dp),
        contentColor = colorResource(id = R.color.purple_200),
        elevation = FloatingActionButtonDefaults.elevation(10.dp),
        onClick = {
           // isClicked = true
            //NavigationDashBoard()
            scope.launch {
                snackbarHostState.showSnackbar("Snackbar")
            }
        },
        //containerColor = Color.LightGray

    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_photo_camera_24),
            contentDescription = "Add icon"
        )
    }*/
       tabHome()

    }

} // home
@Composable
fun tabHome() {

    val list = listOf("Android","Kotlin","jetpack compose","Java","Android","Kotlin"
        ,"jetpack compose","Java","Android","Kotlin","jetpack compose","50","40"
        ,"30","20","10","Android","Kotlin","jetpack compose","Java","Android","Kotlin"
        ,"jetpack compose","Java","Android","Kotlin","jetpack compose","50","40"
        ,"30","20","10")
    LazyColumn {
        /*items(list){ item ->
         val fontFamily = FontFamily(Font(R.font.aguafina_script,FontWeight.Bold))
        Text(text = "this is android testing of font style ",
            fontFamily = fontFamily,
        )
        }*/
        val fontFamily = FontFamily(Font(R.font.chango,FontWeight.SemiBold))
        itemsIndexed(list) { index, item ->
           Text(text = item,
               modifier = Modifier.padding(start = 15.dp),
               color = Color.Red,
               fontFamily = fontFamily,
               fontWeight = FontWeight.Normal,
               maxLines = 1,

                 )
        }

       
    }

}

@Composable
fun NotificationScreen() {
    CenterText(text = "Notification")


}

@Composable
fun ProfileScreen() {
    CenterText(text = "Profile")
}

@Composable
fun CenterText(text: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val offset = Offset(5.0f,10.0f)
       /* Text(text = text, fontSize = 32.sp, fontWeight = FontWeight.Bold,
            style = TextStyle(
                fontSize = 25.sp,
                shadow = Shadow(
                    color = Color.Blue, offset =offset, blurRadius = 3f
                )
            )
        )*/
        /*Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(color = Color.Red)){
                    append(text[0])
                }
                append(text.lastIndexOf(text[1],text.length,true).toString())
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)) {
                    append("W")
                }
                append("orld")
            }
        )*/
        val gradientColors = listOf(Color.Red,Color.Blue,Color.Magenta)
        SelectionContainer {
            Text(text = text,
                style = TextStyle(brush = Brush.linearGradient(colors = gradientColors)),
                modifier = Modifier.basicMarquee(),
                textAlign = TextAlign.Center
            )
        }

        var txt by remember { mutableStateOf("") }
        val brush = remember {
            Brush.linearGradient(colors = gradientColors)
        }
       TextField(value = txt, onValueChange = {txt =it} ,
           textStyle = TextStyle(brush = brush)
       )
        // key board
       // capitalization
        //autoCorrect
        //keyboardType
        //imeAction
        //val fontFamily = FontFamily(Font(R.font.aclonica), Font(R.font.aguafina_script))
       // Text(text = "Android ", fontFamily = fontFamily, fontWeight = FontWeight.Bold)
        val fontFamily = FontFamily(Font(R.font.chango,FontWeight.Bold))
        Text(text = "this is android testing of font style ",
            fontFamily = fontFamily,
        )
        Image(painter = painterResource(id = R.drawable.img), contentDescription = "Image"
        , contentScale = ContentScale.Crop)
       /* val imageBitmap = ImageBitmap.imageResource(id = R.drawable.doctor)
        Image(painter = painterResource(id = R.drawable.capture), contentDescription ="2" , contentScale = ContentScale.Crop )
        Icon(Icons.Rounded.ShoppingCart, contentDescription = "test  image3" )

        val imageModifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black))
            .background(Color.Yellow)
        Image(
            painter = painterResource(id = R.drawable.ic_visibility_black_18dp),
            contentDescription = stringResource(id = R.string.app_name),
            contentScale = ContentScale.Fit,
            modifier = imageModifier
        )
        val bgmodifier = Modifier
            .width(150.dp)
            .height(40.dp)
            .border(BorderStroke(1.dp, colorResource(id = R.color.topBar)))
           // .background(Color.White)
        
        Button(modifier = bgmodifier, onClick = { *//*TODO*//* }) {
                 Text(text = "Login")
        }*/
        Text(
            "Hello Compose!",
            modifier = Modifier
                .drawWithCache {
                    val brush = Brush.linearGradient(
                        listOf(
                            Color(0xFF9E82F0),
                            Color(0xFF42A5F5)
                        )
                    )
                    onDrawBehind {
                        drawRoundRect(
                            brush,
                            cornerRadius = CornerRadius(10.dp.toPx())
                        )
                    }
                }
        )

        /*Image(painter = painterResource(id = R.drawable.img),
            contentDescription = "Dog",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .aspectRatio(1f)
                .background(
                    Brush.linearGradient(
                        listOf(
                            Color(0xFFC5E1A5),
                            Color(0xFF80DEEA)
                        )
                    )
                )
                .padding(8.dp)
                .graphicsLayer {
                    compositingStrategy = CompositingStrategy.Offscreen
                }
                .drawWithCache {
                    val path = Path()
                    path.addOval(
                        Rect(
                            topLeft = Offset.Zero,
                            bottomRight = Offset(size.width, size.height)
                        )
                    )
                    onDrawWithContent {
                        clipPath(path) {
                            // this draws the actual image - if you don't call drawContent, it wont
                            // render anything
                            this@onDrawWithContent.drawContent()
                        }
                        val dotSize = size.width / 8f
                        // Clip a white border for the content
                        drawCircle(
                            Color.Black,
                            radius = dotSize,
                            center = Offset(
                                x = size.width - dotSize,
                                y = size.height - dotSize
                            ),
                            blendMode = BlendMode.Clear
                        )
                        // draw the red circle indication
                        drawCircle(
                            Color(0xFFEF5350), radius = dotSize * 0.8f,
                            center = Offset(
                                x = size.width - dotSize,
                                y = size.height - dotSize
                            )

                        )


                    }

                }
        )*/



    }
}
