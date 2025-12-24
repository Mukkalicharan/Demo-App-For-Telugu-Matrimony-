package com.my.repo.screens.main

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.my.repo.R


val items8888 =listOf(
    IconsWithItems("Home",R.drawable.outline_home_24),
    IconsWithItems("Matches",R.drawable.outline_group_24),
    IconsWithItems("Interests",R.drawable.baseline_person_24),
    IconsWithItems("Messages",R.drawable.baseline_message_24),
    IconsWithItems("Crown",R.drawable.outline_crown_24),
)
data class IconsWithItems(
    val text:String,
    val icon: Int
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavBar(modifier: Modifier = Modifier) {
    val controller = rememberNavController()
    val selected = items8888[0]
    var selectedBy by remember { mutableStateOf(selected) }
    Scaffold(bottomBar = {
        NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
            items8888.forEachIndexed { v,i->
                NavigationBarItem(
                    selected = i == selectedBy,
                    onClick = {
                        controller.navigate( i.text)
                        selectedBy = i
                    }, icon = {
                        Icon(painter = painterResource(i.icon), contentDescription = i.text)
                    }, label = {
                        Text(text = i.text)
                    })
            }
        }
    }) {
        NavHost(controller, startDestination = selected.text){
            composable("Home") {
                DashBoard()
            }
            composable("Matches") {
                More(R.raw.anima)
            }
            composable("Interests") {
                More(R.raw.intrests)
            }
            composable("Messages") {
                More(R.raw.message)
            }
            composable("Crown") {
                More(R.raw.crown)
            }
        }


    }
}