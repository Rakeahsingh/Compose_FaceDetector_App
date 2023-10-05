package com.example.facedetectorapp.navigation

enum class FaceDetectorApp {
    MainScreen;

    companion object{
        fun fromRoute(route: String?): FaceDetectorApp{
            return when(route?.substringBefore("/")){
                MainScreen.name -> MainScreen
                null -> MainScreen
                else -> throw IllegalArgumentException("Route $route is not Recognized")
            }
        }
    }
}