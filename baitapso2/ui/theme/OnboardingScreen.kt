package com.example.baitapso2.ui.theme

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import com.example.baitapso2.R
import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.baitapso2.MainActivity

val onboardingPages = listOf(
    OnboardingItem(R.drawable.splash_image, "UTH SmartTasks", ""),
    OnboardingItem(R.drawable.increase_work_effectiveness, "", ""),
    OnboardingItem(R.drawable.reminder_notification, "", ""),
    OnboardingItem(R.drawable.new_feature, "", "")
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen() {
    val context = LocalContext.current
    val pagerState = rememberPagerState { onboardingPages.size }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(onClick = { context.startActivity(Intent(context, MainActivity::class.java)) }) {
                Text("Skip", fontSize = 20.sp, color = Color.Blue)
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            OnboardingPage(onboardingPages[page])
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            onboardingPages.indices.forEach { index ->
                Box(
                    modifier = Modifier
                        .size(if (pagerState.currentPage == index) 10.dp else 6.dp)
                        .padding(4.dp)
                        .background(
                            if (pagerState.currentPage == index) Color.Blue else Color.Gray,
                            CircleShape
                        )
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (pagerState.currentPage == 2 || pagerState.currentPage == 3) {
                Button(
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(pagerState.currentPage - 1) } },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                    modifier = Modifier.size(65.dp).padding(bottom = 20.dp),
                    shape = CircleShape
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(100.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
            }


            if (pagerState.currentPage < onboardingPages.size - 1 && pagerState.currentPage > 0) {
                Button(
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) } },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f).height(65.dp).padding(bottom = 20.dp)
                ) {
                    Text("Next", fontSize = 20.sp)
                }
            } else if (pagerState.currentPage == onboardingPages.size - 1) {
                Button(
                    onClick = { context.startActivity(Intent(context, MainActivity::class.java)) },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.weight(1f).height(65.dp).padding(bottom = 20.dp)
                ) {
                    Text("Get Started", fontSize = 20.sp)
                }
            }
        }
    }
}

@Composable
fun OnboardingPage(item: OnboardingItem) {
    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(if (item.title == "UTH SmartTasks") 60.dp else 280.dp)
                .border(2.dp, if (item.title == "UTH SmartTasks") Color.Yellow else Color.Transparent, RoundedCornerShape(4.dp))
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = item.title,
            fontSize = if (item.title == "UTH SmartTasks") 32.sp else 24.sp,
            fontWeight = if (item.title == "UTH SmartTasks") FontWeight.Bold else FontWeight.Normal,
            color = if (item.title == "UTH SmartTasks") Color.Blue else Color.Black,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.description, fontSize = 16.sp, color = Color.Gray, textAlign = androidx.compose.ui.text.style.TextAlign.Center)
    }
}

data class OnboardingItem(val imageRes: Int, val title: String, val description: String)
