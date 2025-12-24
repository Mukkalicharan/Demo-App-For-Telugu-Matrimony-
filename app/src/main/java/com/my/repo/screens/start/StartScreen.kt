package com.my.repo.screens.start

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.my.repo.R
import com.my.repo.ui.theme.ORANGE


@Composable
fun StartActivity(login:()->Unit,register:()-> Unit) {
    Column {
        Box(Modifier.fillMaxSize()) {
            Column(modifier = Modifier) {
                Image(
                    painter = painterResource(R.drawable.test),
                    null, contentScale = ContentScale.Crop,
                    modifier = Modifier.weight(4.5f)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(5.5f).verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "LoyalLinks", modifier = Modifier
                            .padding(25.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight(500),
                        fontSize = TextUnit(25f, TextUnitType.Sp)
                    )
                    Text(
                        text = "The biggest and more trusted\nmatrimony service for Telugu!",
                        modifier = Modifier
                            .padding(0.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight(300),
                        fontSize = TextUnit(17f, TextUnitType.Sp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(30.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            modifier = Modifier
                                .border(
                                    BorderStroke(
                                        1.dp,
                                        Color.Black
                                    ), shape = RoundedCornerShape(5.dp)
                                )
                        ) {
                            Text(
                                text = "తెలుగులో చూడండి ➤",
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight(300),
                                fontSize = TextUnit(16f, TextUnitType.Sp),
                                modifier = Modifier.padding(8.dp, 5.dp)
                            )
                        }

                    }
                    Text(
                        text = "New user?", modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight(500),
                        fontSize = TextUnit(20f, TextUnitType.Sp)
                    )
                    Button(
                        onClick = {
                            register.invoke()
                        }, modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp), colors = ButtonDefaults.buttonColors(
                            ORANGE
                        )
                    ) {

                        Text(
                            text = "Create profile", modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight(450),
                            fontSize = TextUnit(16f, TextUnitType.Sp)
                        )
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Spacer(
                            modifier = Modifier
                                .height(0.9.dp)
                                .width(100.dp)
                                .background(
                                    Color.Gray
                                )
                        )
                        Text(text = "or", modifier = Modifier.padding(start = 10.dp, end = 10.dp))
                        Spacer(
                            modifier = Modifier
                                .height(0.9.dp)
                                .width(100.dp)
                                .background(
                                    Color.Gray
                                )
                        )
                    }
                    Row(
                        modifier = Modifier.padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Already registered?",
                            modifier = Modifier
                                .padding(0.dp),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight(450),
                            fontSize = TextUnit(16f, TextUnitType.Sp)
                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Column(
                            modifier = Modifier
                                .padding(5.dp, 10.dp)
                                .border(
                                    2.dp, ORANGE,
                                    shape = RoundedCornerShape(20.dp)
                                )
                        ) {
                            Text(
                                text = "Login", modifier = Modifier.padding(
                                    horizontal = 50.dp, vertical = 10.dp
                                ).clickable{
                                    login.invoke()
                                },
                                textAlign = TextAlign.Center,
                                color = ORANGE,
                                fontWeight = FontWeight(500),
                                fontSize = TextUnit(14f, TextUnitType.Sp)
                            )
                        }
                    }
                }
            }
        }
    }
}