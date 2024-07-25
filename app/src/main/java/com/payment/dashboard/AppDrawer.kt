package com.payment.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.payment.dashboard.ui.theme.Purple40
import com.payment.dashboard.ui.theme.Purple80

@Composable
fun AppDrawer(
    route: String,
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit = {},
    navigateToEmails: () -> Unit = {},
    navigateToMessages: () -> Unit = {} ,
    closeDrawer: () -> Unit = {}
){
  ModalDrawerSheet {
            DrawerHeader(modifier )
          // Spacer(modifier = modifier.padding(10.dp))
           Column(modifier = Modifier
               .fillMaxSize()
               .background(color = colorResource(id = R.color.white))
           ) {
               NavigationDrawerItem(
                   label = { Text(text = "Home")},
                   selected = route == AllDestinations.HOME,
                   onClick = {
                              navigateToHome()
                             closeDrawer()
                             },
                   icon = {
                        Icon(painterResource(id = R.drawable.baseline_home_24), contentDescription =  "Home",
                            modifier = Modifier.size(25.dp))
                   },
                   shape = MaterialTheme.shapes.medium,
                   colors = NavigationDrawerItemDefaults.colors(
                       selectedContainerColor = Color.DarkGray,
                       unselectedContainerColor = Color.Transparent,
                       selectedTextColor = Color.White,
                       unselectedTextColor = Color.Black,
                       selectedIconColor = Color.White,
                       unselectedIconColor = Color.Black
                   ),
                   modifier = Modifier
                       .padding(end = 10.dp, start = 10.dp, top = 10.dp)
                       .clip(RoundedCornerShape(25.dp))
               )
               NavigationDrawerItem(
                   label = {  Text(text = "Emails") },
                   selected = route == AllDestinations.EMAILS ,
                   onClick = {
                       navigateToEmails()
                       closeDrawer()
                   },
                   icon = {
                       Icon(painterResource(id = R.drawable.baseline_email_24), contentDescription =  "Email",
                           modifier = Modifier.size(25.dp))
                   },
                   shape = MaterialTheme.shapes.medium,
                   colors = NavigationDrawerItemDefaults.colors(
                      /* selectedContainerColor = Color.DarkGray,
                       unselectedContainerColor = Color.Transparent,
                       selectedTextColor = Color.White,
                       // unselectedTextColor = Color.Black,
                       selectedIconColor = Color.White,
                       unselectedIconColor = Color.Black*/
                       selectedContainerColor = Color.DarkGray,
                       unselectedContainerColor = Color.Transparent,
                       selectedTextColor = Color.White,
                       unselectedTextColor = Color.Black,
                       selectedIconColor = Color.White,
                       unselectedIconColor = Color.Black
                   ),
                   modifier = Modifier
                       .padding(end = 10.dp, start = 10.dp)
                       .clip(RoundedCornerShape(25.dp))
               )
               NavigationDrawerItem(
                   label = {  Text(text = "Message") },
                   selected = route == AllDestinations.MESSAGES ,
                   onClick = {
                       navigateToMessages()
                       closeDrawer()
                   },
                   icon = {
                       Icon(painterResource(id = R.drawable.baseline_message_24), contentDescription =  "msg",
                           modifier = Modifier.size(25.dp))
                   },
                   shape = MaterialTheme.shapes.medium,
                   colors = NavigationDrawerItemDefaults.colors(
                       selectedContainerColor = Color.DarkGray,
                       unselectedContainerColor = Color.Transparent,
                       selectedTextColor = Color.White,
                       unselectedTextColor = Color.Black,
                       selectedIconColor = Color.White,
                       unselectedIconColor = Color.Black
                   ),
                   modifier = Modifier
                       .padding(end = 10.dp, start = 10.dp)
                       .clip(RoundedCornerShape(25.dp))
               )

           }
  }

}

@Composable
fun DrawerHeader(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(color = Purple40)
            .padding(16.dp)
            .fillMaxWidth()
    ) {

        Image(
            painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(120.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = "Android User",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color =  MaterialTheme.colorScheme.background,
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            //text = stringResource(id = R.string.app_name),
            text =  "Android System Administrator",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.background,
        )
    }
}
