package com.example.final_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.final_project.guitarlist.GuitarList
import com.example.final_project.guitarlist.GuitarListBody
import com.example.final_project.login.Login
import com.example.final_project.services.viewmodels.LoginViewModel
import com.example.final_project.splash.Splash
import com.example.final_project.ui.theme.Final_projectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Final_projectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "splash"
                    ) {
                        composable("splash") {
                            Splash(navController = navController)
                        }
                        composable("login"){
                            Login(viewModel = LoginViewModel(), navController = navController)
                        }
                        composable("list"){
                           GuitarListBody()
                        }
                    }
                }
            }
        }
    }
}
