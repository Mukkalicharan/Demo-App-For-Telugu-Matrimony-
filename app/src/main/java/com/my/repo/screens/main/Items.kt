package com.my.repo.screens.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.my.repo.R
import com.my.repo.ui.theme.LITE_ORANGE_TRAN
import com.my.repo.ui.theme.ORANGE

@Composable
fun Part1Card() {
    LazyHorizontalGrid(rows = GridCells.FixedSize(size = 200.dp), modifier =
        Modifier.height(130.dp).fillMaxWidth()) {
        items(items){
            Card(modifier = Modifier
                .wrapContentSize()
                .padding(8.dp), colors = CardDefaults.cardColors(
                Color.White,
            ), elevation = CardDefaults.cardElevation(5.dp)) {
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .padding(5.dp)
                    .width(92.dp)
                    .height(110.dp)){
                    Image(painter = painterResource(it.id),null, modifier = Modifier
                        .width(45.dp)
                        .height(45.dp))
                    Text(text = it.content, fontWeight = FontWeight.SemiBold, fontSize = TextUnit(15f,
                        TextUnitType.Sp), textAlign = TextAlign.Center, modifier = Modifier.padding(top = 10.dp))
                }
            }
        }
    }
}


val items = listOf(
    Items("Verify Problem",R.drawable.verify_phone),
    Items("Family Details",R.drawable.home_of),
    Items("Hobbies",R.drawable.hobbies_of)
)

data class Items (
    val content:String,
    val id:Int
)


@Composable
fun DailyRecommendation(text1:String,text2:String) {
    Column (modifier = Modifier.fillMaxWidth()){
        Text(text = text1, fontSize = TextUnit(18f, TextUnitType.Sp),
            fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp))
        Text(text=text2, modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp))
        LazyHorizontalGrid(rows = GridCells.Fixed(1),
            modifier = Modifier.height(220.dp)) {
            items(item2){
                Column(modifier = Modifier.padding(10.dp)) {
                    Card(shape = RoundedCornerShape(20.dp)) {
                        Image(painter = painterResource(it.image)
                            ,null, contentScale = ContentScale.Crop,
                            modifier = Modifier.width(140.dp).height(140.dp))
                    }
                    Text(text = it.name, fontSize = TextUnit(16f, TextUnitType.Sp),
                        fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 8.dp))
                    Text(text = it.ageHigh, modifier = Modifier.padding(top = 5.dp), fontSize = TextUnit(16f,
                        TextUnitType.Sp), fontWeight = FontWeight.Medium)
                }
            }
        }
        Button(onClick = {

        }, colors = ButtonDefaults.buttonColors(
            LITE_ORANGE_TRAN
        ), modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp), border = BorderStroke(1.2.dp,
            ORANGE)
        ) {
            Text(text = "View all >", fontWeight = FontWeight.SemiBold, fontSize = TextUnit(12f,
                TextUnitType.Sp), color = ORANGE
            )
        }
    }
}

val item2 = listOf(
    Profiles(R.drawable.vijay,"Vijay Joseph","42 Yrs, 5'9*"),
    Profiles(R.drawable.vijay_se,"Vijay Sethupati","42 Yrs, 5'9*"),
    Profiles(R.drawable.vijay,"Vijay Joseph","42 Yrs, 5'9*")
)

data class Profiles(
    val image:Int,
    val name:String,
    val ageHigh:String
)

@Composable
fun More(res:Int) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(resId =res ))
//    val anim by animateLottieCompositionAsState(
//        composition = composition,
//        iterations = LottieConstants.IterateForever,
//        isPlaying = true,
//        speed = 1f,
//        restartOnPlay = false
//    )
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        LottieAnimation(composition = composition)
        Text(text = "Wait a bit for More Features in the Application")
    }
}