package com.my.repo.screens.start

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.my.repo.R
import com.my.repo.ViewModels
import com.my.repo.ui.theme.GREEN
import com.my.repo.ui.theme.ORANGE



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CreateProfile(modifier: Modifier = Modifier,nav: NavController) {
    Scaffold(
        topBar = {
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
                        Icon(imageVector = Icons.Default.ArrowBack, null)
                    }
                    Text(
                        text = "Create Profile",
                        fontWeight = FontWeight.Bold,
                        fontSize = TextUnit(18f, TextUnitType.Sp),
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
        }, modifier = Modifier
            .fillMaxSize()
            .background(Color.White), containerColor = Color.White, content = {
            DesignStarter()
        }
    )
}

@Composable
fun DesignStarter(view: ViewModels = viewModel()) {
    var checkEnabled by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(top = 100.dp, start = 20.dp, end = 20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(200f),
            modifier = Modifier
                .width(120.dp)
                .height(120.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(2.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            ) {
                Text(text = "L", fontSize = TextUnit(100f, TextUnitType.Sp))


            }

        }
        Text(
            text = "Welcome to Telugu Matrimony!",
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold, color = Color.Gray,
            fontSize = TextUnit(22f, TextUnitType.Sp)
        )
        Text(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            text = "I am creating the profile for",
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold, color = Color.Black,
            fontSize = TextUnit(17f, TextUnitType.Sp)
        )
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 120.dp),
            modifier = Modifier.padding(end = 100.dp), contentPadding = PaddingValues(1.dp)
        ) {
            items(view.items) {
                if (it.selected) {
                    checkEnabled = true
                }
                Card(
                    modifier = Modifier
                        .padding(8.dp), shape = RoundedCornerShape(100.dp),
                    colors = CardDefaults.cardColors(if (it.selected) GREEN else Color.White),
                    border = BorderStroke(1.dp, Color.Black)
                ) {
                    Column(
                        modifier = Modifier
                            .then(
                                if (!it.selected) {
                                    Modifier.clickable {
                                        view.updateItems(it)
                                    }
                                } else {
                                    Modifier
                                })
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(15.dp)
                                .fillMaxWidth(),
                            text = it.item,
                            textAlign = TextAlign.Center,
                            color = Color.Black,
                            fontSize = TextUnit(16f, TextUnitType.Sp)
                        )
                    }
                }
            }
        }

        if (checkEnabled) {
            SpinnerSelection()
        }
        Button(
            onClick = {

            }, colors = ButtonDefaults.buttonColors(
                ORANGE
            ), modifier = Modifier.padding(top = 30.dp)
        ) {
            Text(
                text = "Start Registration",
                modifier = Modifier
                    .padding(vertical = 6.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold, color = Color.White,
                fontSize = TextUnit(17f, TextUnitType.Sp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpinnerSelection() {

    var stateOf by remember {
        mutableStateOf(false)
    }
    var selectedTxt by remember {
        mutableStateOf(indianLanguages.first())
    }
    Column {

        Text(
            text = "Mother tongue",
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold, color = Color.Gray,
            fontSize = TextUnit(24f, TextUnitType.Sp)
        )
        ExposedDropdownMenuBox(expanded = stateOf, onExpandedChange = {
            stateOf = !stateOf
        }) {
            OutlinedTextField(
                readOnly = true,
                value = selectedTxt,
                onValueChange = {},
                label = { Text(text = "Your mother tongue", color = Color.Black) },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = stateOf)
                },
                colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(
                    errorLabelColor = Color.White,
                    focusedLabelColor = Color.White,
                    disabledLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    errorBorderColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    disabledBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                ),
                modifier = Modifier
                    .menuAnchor(type = MenuAnchorType.PrimaryEditable),
                shape = RoundedCornerShape(10.dp)
            )
            ExposedDropdownMenu(expanded = stateOf, onDismissRequest = {
                stateOf = false
            }) {
                for (string in indianLanguages) {
                    DropdownMenuItem(text = { Text(text = string) }, onClick = {
                        stateOf = false
                        selectedTxt = string
                    })
                }
            }
        }
    }

}


val indianLanguages = arrayListOf(
    "Telugu",
    "English",
    "Bengali",
    "Marathi",
    "Hindi",
    "Tamil",
    "Urdu",
    "Gujarati",
    "Kannada",
    "Odia",
    "Malayalam",
    "Punjabi",
    "Assamese",
    "Maithili",
    "Sanskrit",
    "Kashmiri",
    "Sindhi",
    "Dogri",
    "Manipuri (Meitei)",
    "Bodo",
    "Santhali",
    "Konkani",
    "Nepali"
)


