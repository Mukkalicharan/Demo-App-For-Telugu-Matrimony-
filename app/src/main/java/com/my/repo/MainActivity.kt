package com.my.repo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.my.repo.screens.main.NavBar
import com.my.repo.screens.start.CreateProfile
import com.my.repo.screens.start.LoginOtp
import com.my.repo.screens.start.StartActivity
import com.my.repo.ui.theme.Demo2Theme

class MainActivity : ComponentActivity() {
    val model by viewModels<ViewModels>()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Demo2Theme {
                val nav = model.navHost.value
                val current = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    if(nav=="Start"){
                        NavHost(navController = current, startDestination = "StartScreen", modifier = Modifier.padding(bottom=50.dp)){
                            composable("StartScreen") {
                                StartActivity(
                                    login = { current.navigate("Login") },
                                    register = { current.navigate("Register") }
                                )
                            }
                            composable("Login") {
                                LoginOtp(nav=current,view=model)
                            }
                            composable("Register") {
                                CreateProfile(nav=current, modifier = Modifier)
                            }
                        }
                    }else{
                        NavBar()
                    }
                }
            }
        }
    }

}
