package com.example.zerentapp.presentation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.zerentapp.data.DummyData.onboardings
import com.example.zerentapp.presentation.component.FinishButton
import com.example.zerentapp.presentation.component.OnBoarding
import com.example.zerentapp.presentation.component.PageIndicator
import com.example.zerentapp.ui.theme.color1
import com.example.zerentapp.ui.theme.poppinsFontFamily

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        val pagerState = rememberPagerState (initialPage = 0) {
            onboardings.size
        }

        val buttonState = remember {
            derivedStateOf {
                when(pagerState.currentPage){
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pagerState) {index ->
            OnBoarding(onboarding = onboardings[index])
        }
        Spacer(modifier = Modifier.weight(1f))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            PageIndicator(
                modifier = Modifier.width(52.dp),
                pageSize = onboardings.size,
                selectedPage = pagerState.currentPage
            )
        }

        FinishButton(
            modifier = Modifier.weight(1f),
            pagerState = pagerState,
           navController = navController
            ) {

        }

        Spacer(modifier = Modifier.weight(2f))
        
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 28.dp)
                .background(color1)
                .height(31.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ){
            Text(
                text = "Kualitas Tanpa Kepemilikan, Nikmati dengan Sewa",
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
                fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal,
                color = Color.White
                )
        }
    }
}