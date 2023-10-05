package com.example.facedetectorapp.repository

import android.graphics.Bitmap
import kotlinx.coroutines.flow.Flow

interface MainRepo {



    fun startFaceDetector(): Flow<String?>

}