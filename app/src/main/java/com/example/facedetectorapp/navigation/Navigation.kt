package com.example.facedetectorapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.facedetectorapp.screen.MainScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = FaceDetectorApp.MainScreen.name
    ){
        composable(FaceDetectorApp.MainScreen.name){
            MainScreen(navController = navController)
        }
    }

}