package com.payment.dashboard.screens

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.viewpager.ViewPagerItem
import com.example.viewpager.viewPagerDotsIndicator
import com.payment.dashboard.Home_Modal
import com.payment.dashboard.MainActivity2
import com.payment.dashboard.R
import com.payment.dashboard.database.ResidentDataBase
import com.payment.dashboard.modal.ResidentCompleteSearchItem
import com.payment.dashboard.utility.getImgUrl
import com.payment.dashboard.viewmodal.MainViewModal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun Home(navController: NavHostController) {
    val context = LocalContext.current
    val viewModal = MainViewModal()
    val scope = rememberCoroutineScope()
    var images: List<ResidentCompleteSearchItem> = emptyList()
   // viewModal.getResidentCompleteSearch("", "", "")

    //Log.e("HOME ","HOME >>>>>>>>> : "+viewModal.residentCompleteSearchListResponse.size)


    Surface(modifier = Modifier.fillMaxSize(), color = colorResource(id = R.color.sb)) {
        val context = LocalContext.current
        var isClicked by remember { mutableStateOf(false) }

       /* val images = listOf(
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background,
        )*/
        images = listOf(
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
                " R.drawable.ic_launcher_background ",
                "AllergyData__20240223.xlsx",
                "Date(1708718409703)",
                "National Institutes of Health Clinical Center Program",
                "Allergy and Immunology",
                "Bethesda MD",
            ),
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
                " R.drawable.ic_launcher_background ",
                "AllergyData__20240223.xlsx",
                "Date(1708718409703)",
                "National Institutes of Health Clinical Center Program",
                "Allergy and Immunology",
                "Bethesda MD",
            ),
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
                " R.drawable.ic_launcher_background ",
                "AllergyData__20240223.xlsx",
                "Date(1708718409703)",
                "National Institutes of Health Clinical Center Program",
                "Allergy and Immunology",
                "Bethesda MD",
            ),
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
                " R.drawable.ic_launcher_background ",
                "AllergyData__20240223.xlsx",
                "Date(1708718409703)",
                "National Institutes of Health Clinical Center Program",
                "Allergy and Immunology",
                "Bethesda MD",
            ),
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
                " R.drawable.ic_launcher_background ",
                "AllergyData__20240223.xlsx",
                "Date(1708718409703)",
                "National Institutes of Health Clinical Center Program",
                "Allergy and Immunology",
                "Bethesda MD",
            ),
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
                " R.drawable.ic_launcher_background ",
                "AllergyData__20240223.xlsx",
                "Date(1708718409703)",
                "National Institutes of Health Clinical Center Program",
                "Allergy and Immunology",
                "Bethesda MD",
            ),
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
                " R.drawable.ic_launcher_background ",
                "AllergyData__20240223.xlsx",
                "Date(1708718409703)",
                "National Institutes of Health Clinical Center Program",
                "Allergy and Immunology",
                "Bethesda MD",
            ),
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
                " R.drawable.ic_launcher_background ",
                "AllergyData__20240223.xlsx",
                "Date(1708718409703)",
                "National Institutes of Health Clinical Center Program",
                "Allergy and Immunology",
                "Bethesda MD",
            ),
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
                " R.drawable.ic_launcher_background ",
                "AllergyData__20240223.xlsx",
                "Date(1708718409703)",
                "National Institutes of Health Clinical Center Program",
                "Allergy and Immunology",
                "Bethesda MD",
            ),
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
                " R.drawable.ic_launcher_background ",
                "AllergyData__20240223.xlsx",
                "Date(1708718409703)",
                "National Institutes of Health Clinical Center Program",
                "Allergy and Immunology",
                "Bethesda MD",
            )

        )


        scope.launch(Dispatchers.IO)  {
            images =  ResidentDataBase.getInstance(context).residentDao().getAllResidents()
        }


        Column(
            modifier = Modifier
                .padding()
                .fillMaxWidth()
                .height(150.dp),
        ) {
            //   val pagerState = rememberPagerState(initialPage = 0,pageCount = {5})
            // Used Int.MAX_VALUE for infinity scroll
            val pageCount = Int.MAX_VALUE
            // The actual view pager size (for the HorizontalPagerIndicator)
            val realSize = images.size
            // Start from the middle in order to the infinity scroll for both sides
            val middlePage = pageCount / 2
            // Init the PagerState with a very large number and make it always start from the first item of the real list
            val vv = middlePage - (middlePage % realSize)
            val pagerState = rememberPagerState(initialPage = vv, pageCount = { images.size })
            val isDraggedState = pagerState.interactionSource.collectIsDraggedAsState()
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .shadow(elevation = 5.dp, shape = RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .height(150.dp)
                    .clickable {
                        //  Log.e("clicked", "clicked on the screen: " + pagerState.currentPage)
                        //  isClicked = true
                        context.startActivity(Intent(context, MainActivity2::class.java))
                    }
            ) {
                HorizontalPager(state = pagerState) { page ->
                    ViewPagerItem(page = page, Color.White, images)
                }

                viewPagerDotsIndicator(
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    pagesCount = images.size,
                    currentPageIteration = pagerState.currentPage
                )
            }
            // Start auto-scroll effect
            LaunchedEffect(isDraggedState) {
                // convert compose state into flow
                snapshotFlow { isDraggedState.value }
                    .collectLatest { isDragged ->
                        // if not isDragged start slide animation
                        if (!isDragged) {
                            // infinity loop
                            while (true) {
                                // duration before each scroll animation
                                delay(1_000L)
                                runCatching {
                                    pagerState.animateScrollToPage(pagerState.currentPage.inc() % pagerState.pageCount)
                                }
                            }
                        }
                    }
            }
        }



    }

    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(top = 150.dp))
    {
        // content
        Column(
            modifier = Modifier

                .padding(top = 10.dp, start = 5.dp, end = 5.dp),
            /* verticalArrangement = Arrangement.Center,
              horizontalAlignment = Alignment.CenterHorizontally*/
        ) {

            val list = listOf(
                Home_Modal("Android", R.drawable.resident_logo2),
                Home_Modal("Kotlin", R.drawable.baseline_tv_24),
                Home_Modal("Java", R.drawable.baseline_newspaper_24),
                Home_Modal("React", R.drawable.baseline_menu_24),
                Home_Modal("Angular", R.drawable.baseline_message_24),
                Home_Modal("Flatter", R.drawable.baseline_email_24),
                Home_Modal("Dot", R.drawable.baseline_newspaper_24),
                Home_Modal("JavaScript", R.drawable.baseline_movie_24),
                Home_Modal("Html", R.drawable.ic_launcher_background),
                Home_Modal("Php", R.drawable.capture),
                Home_Modal(".Net", R.drawable.doctor),
                Home_Modal("Ios", R.drawable.img),
                Home_Modal("c and c++", R.drawable.resident_logo)
            )

            /*  Log.e("Count","size <><>>>>>>: "+ viewModal. stateListResponse.size)
              viewModal. stateListResponse.forEach{
                  Log.e("Count","Location <><>>>>>>: "+ it.Location)
              }*/

            var showWebView by remember { mutableStateOf(false) }
            var providerName by remember { mutableStateOf("") }
            var locationName by remember { mutableStateOf("") }
            var pgyName by remember { mutableStateOf("") }

            viewModal.getResidentCompleteSearch("", "", "")

            LazyRow {
                if (viewModal.residentCompleteSearchListResponse.isNotEmpty()){

                    itemsIndexed(viewModal.residentCompleteSearchListResponse) { index, item ->
                        // itemsIndexed(list) { index: Int, item: String ->

                          if (index < 10 ){
                              Log.e("Home","Home <><>>>>>>: "+ viewModal.residentCompleteSearchListResponse.size)

                              val context = LocalContext.current
                              scope.launch(Dispatchers.IO)  {
                                  ResidentDataBase.getInstance(context).residentDao().insertResident(
                                      ResidentCompleteSearchItem(
                                          item.ID, item.ProgramID,
                                          item.Location, item.Provider_Name,
                                          item.PGY,item.ClassOf,item.UnderGraduateCollege,
                                          item.MedicalSchool,item.Internship,
                                          item.Major,item.Fellowship,
                                          item.HomeTown,item.MailID,
                                          item.PhoneNo,item.Misc,
                                          item.Photo,item.FileName,
                                          item.TimeStamp,item.ProgramName,
                                          item.Speciality,item.ProgramLocation
                                      )
                                  )
                              }


                              Card(
                                  modifier = Modifier
                                      .padding(5.dp)
                                      .size(150.dp)
                                      .align(Alignment.CenterHorizontally),
                                  colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
                                  elevation = CardDefaults.cardElevation(4.dp)
                              ) {
                                  Column(modifier = Modifier
                                      .padding(top = 20.dp)
                                      .align(Alignment.CenterHorizontally)) {
                                      /* Image(
                                           painter = painterResource(id = item.icon),
                                           modifier = Modifier
                                               .width(100.dp)
                                               .height(100.dp)
                                               .align(Alignment.CenterHorizontally),
                                           contentDescription = null
                                       )*/
                                      val imageUrl = getImgUrl() + item.Photo
                                      AsyncImage(
                                          model = imageUrl,
                                          contentDescription = "Resident user Image",
                                          placeholder = painterResource(id = R.drawable.doctor),
                                          error = painterResource(id = R.drawable.doctor),
                                          contentScale = ContentScale.Crop,
                                          modifier = Modifier
                                              .size(80.dp)
                                              .align(Alignment.CenterHorizontally)
                                              .clip(shape = CutCornerShape(10.dp)),
                                      )
                                      Text(
                                          text = item.Location.toString(),
                                          modifier = Modifier
                                              .padding(top = 15.dp)
                                              .align(Alignment.CenterHorizontally)
                                          /*.fillMaxSize()
                                           .align(Alignment.CenterHorizontally)*/
                                      )

                                  }
                              }
                          }



                        //Divider()
                    }
                }
            }
        }
        Card(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .height(150.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_movie_24),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = "Movies", modifier = Modifier.padding(10.dp))
                }
                Column {

                }
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_newspaper_24),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = "News", modifier = Modifier.padding(10.dp))
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = "Email", modifier = Modifier.padding(10.dp))
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                color = colorResource(id = R.color.purple_700),
                                shape = CircleShape
                            )
                            .clickable(
                                onClick = {
                                    Log.e("Imaheclicked", "clicked item : ><<<<<<<<")
                                },
                                onClickLabel = "open for more"
                            )
                    )
                    Text(text = "More", modifier = Modifier.padding(10.dp))
                }
            }
        }
        //  2nd Card
        Card(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .height(150.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_movie_24),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = "Movies", modifier = Modifier.padding(10.dp))
                }

                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_newspaper_24),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = "News", modifier = Modifier.padding(10.dp))
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = "Email", modifier = Modifier.padding(10.dp))
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                color = colorResource(id = R.color.purple_700),
                                shape = CircleShape
                            )
                            .clickable(
                                onClick = {
                                    Log.e("Imaheclicked", "clicked item : ><<<<<<<<")
                                },
                                onClickLabel = "open for more"
                            )
                    )
                    Text(text = "More", modifier = Modifier.padding(10.dp))
                }
            }
        }
        Card(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .height(150.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_movie_24),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = "Movies", modifier = Modifier.padding(10.dp))
                }
                Column {

                }
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_newspaper_24),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = "News", modifier = Modifier.padding(10.dp))
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_email_24),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(text = "Email", modifier = Modifier.padding(10.dp))
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_ios_24),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                color = colorResource(id = R.color.purple_700),
                                shape = CircleShape
                            )
                            .clickable(
                                onClick = {
                                    Log.e("Imaheclicked", "clicked item : ><<<<<<<<")
                                },
                                onClickLabel = "open for more"
                            )
                    )
                    Text(text = "More", modifier = Modifier.padding(10.dp))
                }
            }
        }

    }//column
}


@Preview
@Composable
fun GreetingSecondPreview() {
    // Home()
}
