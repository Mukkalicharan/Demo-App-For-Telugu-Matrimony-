package com.my.repo.screens.main

import android.annotation.SuppressLint
import android.text.Layout
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.sharp.Notifications
import androidx.compose.material.icons.twotone.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.my.repo.R
import com.my.repo.ui.theme.DARK_GRAY
import com.my.repo.ui.theme.LIGHT_GREENISH
import com.my.repo.ui.theme.LITE_ORANGE
import com.my.repo.ui.theme.LITE_ORANGE_TRAN
import com.my.repo.ui.theme.ORANGE


@Composable
fun CompleteProfile() {
    Column(modifier = Modifier.padding(vertical =  20.dp, horizontal = 20.dp)) {
        Text(text = "Complete Your Profile", fontWeight = FontWeight.SemiBold,
            fontSize = TextUnit(25f, TextUnitType.Sp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Profile completeness score 77%", modifier = Modifier.padding(vertical = 10.dp,))
            Spacer(modifier = Modifier.padding(end = 10.dp))
            LinearProgressIndicator(progress = { 0.7f },color= DARK_GRAY, modifier = Modifier.height(10.dp).width(50.dp))
        }
    }
}

@Composable
fun DashBoard(modifier: Modifier = Modifier) {
    val scroll = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scroll)
    ) {
        Column (modifier
            .background(LIGHT_GREENISH)){
            Chooser({}, modifier = modifier.padding(top = 20.dp))
            Profile()
            HorizontalDivider(modifier = Modifier
                .padding(20.dp)
                .height(1.dp)
                .background(color = Color.Black))
            Image(painter = painterResource(R.drawable.banner),null, modifier = Modifier
                .fillMaxWidth()
                .height(200.dp))
        }
        CompleteProfile()
        Part1Card()
        Spacer(modifier = Modifier.height(28.dp))
        HorizontalDivider(modifier = Modifier.height(1.dp).background(Color.Gray))
        Spacer(modifier = Modifier.height(15.dp))
        DailyRecommendation(text1 = "Daily Recommendations", text2 = "Recommended matches for today")
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(modifier = Modifier.height(1.dp).background(Color.Gray))
        HorizontalDivider(modifier = Modifier.height(1.dp).background(Color.Gray))
        Spacer(modifier = Modifier.height(15.dp))
        DailyRecommendation(text1 = "All Matches (928)", text2 = "Members who watches your partners preferences")
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(modifier = Modifier.height(1.dp).background(Color.Gray))
       Banner()
        DailyRecommendation(text1 = "New Matches (59)",
            text2 = "Members who match your preferences and have joined in the last 30 days")
        Spacer(modifier = Modifier.height(20.dp))
        HorizontalDivider(modifier = Modifier.height(1.dp).background(Color.Gray))
    }
}

@Composable
fun Banner() {
        Box(modifier = Modifier.height(400.dp).fillMaxWidth()) {
            Image(painter = painterResource(R.drawable.part_2),null, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth().fillMaxHeight())
            Button(onClick = {}, colors = ButtonDefaults.buttonColors(ORANGE), modifier = Modifier.align(
                Alignment.BottomStart).padding(start = 20.dp, bottom = 40.dp)) {
                Text(text = "See membership plans", fontSize = TextUnit(16f, TextUnitType.Sp), fontWeight = FontWeight.SemiBold)
            }
        }
}


@Composable
fun Profile(modifier: Modifier = Modifier) {
  Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
      Box(modifier = Modifier.weight(2f).padding(10.dp)) {
          Card(shape = RoundedCornerShape(100.dp)) {
              Image(painter = painterResource(R.drawable.girl),
                  null,
                  contentScale = ContentScale.Crop,
                  modifier = Modifier
                      .width(70.dp)
                      .height(70.dp))
          }
          Card(modifier= Modifier
              .padding(5.dp)
              .align(alignment = Alignment.BottomStart), colors = CardDefaults.cardColors(Color.White)) {
//          Icon(painter = painterResource(R.drawable.outline_camera_24),null)
              Image(painter = painterResource(R.drawable.outline_camera_24),null)
          }
      }
      Column (modifier = Modifier
          .padding(start = 10.dp)
          .weight(4f)){
          Text(text = "Deepti", fontSize = TextUnit(16f, TextUnitType.Sp), fontWeight = FontWeight.Bold)
          Text(text = "Loyal Links", modifier = Modifier.padding(5.dp),
              fontSize = TextUnit(13f, TextUnitType.Sp))
          Row(verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center,
              modifier = Modifier.padding(top= 5.dp)) {
              Text(text = "Free Member",
                  modifier= Modifier.padding(end = 10.dp),
                  fontSize = TextUnit(13f, TextUnitType.Sp))
                Column(modifier = Modifier
                    .background(Color.Yellow, shape =
                        RoundedCornerShape(20.dp))) {
                    Text(text = "Upgrade",
                        fontSize = TextUnit(10f, TextUnitType.Sp),
                        modifier = Modifier.border(
                            border = BorderStroke(1.dp, Color.Yellow),
                            shape = RoundedCornerShape(30.dp)
                        ).padding(top = 2.dp, bottom = 2.dp, start = 10.dp, end = 10.dp),
                        color = Color.Black, fontWeight = FontWeight.Normal)
                }
          }
      }
      Row(horizontalArrangement = Arrangement.Center,modifier = Modifier.weight(2f)) {
          Icon(imageVector = Icons.Outlined.Notifications,null,modifier= Modifier
              .width(30.dp)
              .height(30.dp))
          Icon(imageVector = Icons.Rounded.Menu,null,modifier= Modifier
              .width(30.dp)
              .height(30.dp))
      }
  }

}



@SuppressLint("RememberInComposition")
@Composable
fun Chooser(selector: (Boolean) -> Unit, modifier: Modifier) {
    var selected by remember {
        mutableStateOf(false)
    }
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Column (modifier = Modifier.weight(2f)){
            Spacer(modifier)
        }
        Box(
            modifier = Modifier
                .weight(5f)
                .border(
                    border = BorderStroke(0.5.dp, Color.Gray),
                    shape = RoundedCornerShape(80.dp)
                )
                .background(Color.White, shape = RoundedCornerShape(80.dp))
        ) {
            Row {
                Text(
                    text = "Regular",
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .weight(5f)
                        .padding(8.dp)
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null

                        ) {
                            selected = true
                        }, color = if(selected) ORANGE else Color.Black,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "PRIME",
                    fontWeight = FontWeight.Bold,
                    color = if(!selected) ORANGE else Color.Black,
                    modifier = Modifier
                        .weight(5f)
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null
                        ) {
                            selected = false
                        }
                        .padding(8.dp),
                    textAlign = TextAlign.Center
                )
            }
            Row {
                Column(
                    modifier = Modifier
                        .weight(5f)
                        .then(
                            chooser(selected)
                        )
                ) {
                    Spacer(modifier = Modifier.padding(18.dp))
                }
                Column(
                    modifier = Modifier
                        .weight(5f)
                        .then(chooser(!selected))
                        .weight(5f)
                ) {
                    Spacer(modifier = Modifier.padding(18.dp))
                }
            }

        }

            Row (modifier = Modifier
                .weight(4f)
                .height(50.dp)) {

                Image(painter = painterResource(R.drawable.trans),null,
                    modifier
                        .width(50.dp)
                        .height(50.dp))
                Icon(imageVector = Icons.Default.Search,null,
                    modifier
                        .width(40.dp)
                        .height(40.dp))
            }
    }
}

@SuppressLint("ModifierFactoryUnreferencedReceiver", "ModifierFactoryExtensionFunction")
private fun chooser(selected: Boolean): Modifier {
    return if (selected) {
        Modifier
            .background(
                LITE_ORANGE_TRAN,
                shape = RoundedCornerShape(80.dp)
            )
            .border(
                border = BorderStroke(1.2.dp, LITE_ORANGE),
                shape = RoundedCornerShape(80.dp)
            )
    } else {
        Modifier
    }
}


