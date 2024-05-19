package com.example.zerentapp.presentation.component

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zerentapp.data.DummyData.onboardings
import com.example.zerentapp.model.Onboarding
import com.example.zerentapp.ui.theme.ZerentAppTheme
import com.example.zerentapp.ui.theme.color1
import com.example.zerentapp.ui.theme.poppinsFontFamily

@Composable
fun OnBoarding(
    onboarding: Onboarding
){
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .fillMaxHeight(fraction = 0.5f)
                .padding(top = 60.dp),
            painter = painterResource(id = onboarding.image),
            contentDescription = null 
        )

        Text(
            text = onboarding.title,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 12.dp),
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Center,
            fontFamily = poppinsFontFamily, fontWeight = FontWeight.Bold
        )
        Text(
            text = onboarding.description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 36.dp)
                .align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            fontFamily = poppinsFontFamily, fontWeight = FontWeight.Normal
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
){
    Row (
        modifier = Modifier
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ){
        AnimatedVisibility(
            modifier = Modifier
                .fillMaxWidth(),
            visible = pagerState.currentPage == 3
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = color1
                )
                ) {
                Text(
                    text = "Mulai",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    fontFamily = poppinsFontFamily, fontWeight = FontWeight.Medium)
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnBoardingPreview(){
    ZerentAppTheme {
        OnBoarding(onboarding = onboardings[3]
        )
    }
}