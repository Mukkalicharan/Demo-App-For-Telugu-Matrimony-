package com.my.repo.screens.start

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.my.repo.R
import com.my.repo.ViewModels
import com.my.repo.ui.theme.LIGHT_GRAY
import com.my.repo.ui.theme.ORANGE


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginOtp(modifier: Modifier = Modifier,nav: NavController,view: ViewModels) {
    Scaffold(topBar = {
        Row(
            modifier = modifier
                .padding(0.dp)
                .shadow(1.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier
                    .weight(5f)
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    nav.navigateUp()
                }) {
                    Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, null)
                }
                Text(
                    text = "Login with OTP",
                    fontWeight = FontWeight.Bold,
                    fontSize = TextUnit(16f, TextUnitType.Sp),
                    modifier = Modifier.padding(8.dp, 5.dp)
                )
            }
            Column(
                modifier.weight(5f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    painter = painterResource(R.drawable.trans),
                    null,
                    modifier = Modifier
                        .width(150.dp)
                        .height(50.dp)
                )
            }
        }
    }, modifier = Modifier.background(Color.White), containerColor = Color.White, bottomBar = {
        Column(modifier
            .shadow(1.dp)
            .fillMaxWidth()
            .padding(10.dp)) {
            HorizontalDivider(modifier = Modifier
                .height(1.dp)
                .padding(top = 0.dp))
            Row(modifier.padding(15.dp)) {
                Text(
                    text = "Need help with login? Call",
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontSize = TextUnit(13f, TextUnitType.Sp),
                    modifier = modifier.weight(5f)
                )

                Row(modifier = modifier.weight(5f), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Filled.Call,null, modifier = modifier.width(15.dp).height(15.dp))
                    Text(
                        text = "+91 9949591470",
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.End,
                        color = Color.Black,
                        fontSize = TextUnit(12f, TextUnitType.Sp)
                    )
                }
            }

        }
    }) { _ ->
        var mobile by remember {
            mutableStateOf("")
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Card(
                modifier = Modifier
                    .padding(top = 80.dp),
                shape = RoundedCornerShape(corner = CornerSize(200.dp)),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(10.dp),
                border = BorderStroke(1.dp, Color.Cyan)
            ) {
                Image(
                    painter = painterResource(R.drawable.mobile),
                    null, modifier = Modifier
                        .width(150.dp)
                        .height(150.dp)
                        .padding(20.dp)
                )
            }
            Text(
                text = "Enter your register mobile number\nand we will send you an OTP for login",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = TextUnit(17f, TextUnitType.Sp),
                modifier = Modifier.padding(top = 20.dp)
            )
            Row(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(10.dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .weight(3f)
                        .background(
                            LIGHT_GRAY,
                            shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp)
                        )

                        .height(55.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.india),
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp),
                        contentDescription = "null"
                    )
                    Text(text = " +91 ", fontWeight = FontWeight.Bold)
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                }
                TextField(
                    value = mobile, onValueChange = {
                        if(it.length<=10){
                            mobile = it
                        }
                    }, placeholder = {
                        Text(text = "Enter mobile number")
                    }, modifier = Modifier.weight(7f), colors = TextFieldDefaults.colors(
                        unfocusedLabelColor = Color.Transparent,
                        errorLabelColor = Color.Transparent,
                        focusedLabelColor = Color.Transparent,
                        disabledLabelColor = Color.Transparent,
                        errorContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        disabledContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ), maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                )

            }
            Button(
                onClick = {
                    if(mobile.contains("0000000000")){
                        view.navHost.value = "sdfgsdfsdfs"
                    }
                },
                modifier = Modifier.padding(top = 20.dp),
                colors = ButtonDefaults.buttonColors(if (mobile.length >= 9) ORANGE else LIGHT_GRAY)
            ) {
                Text(
                    text = "Get OTP",
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    color = if (mobile.length >= 9) Color.White else Color.Gray,
                    fontSize = TextUnit(17f, TextUnitType.Sp)
                )
            }
            Text(
                text = "Login with password",
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                color = ORANGE,
                fontSize = TextUnit(15f, TextUnitType.Sp),
                modifier = modifier.padding(top = 20.dp)
            )
        }

    }
}