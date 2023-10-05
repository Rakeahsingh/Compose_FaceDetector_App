package com.example.facedetectorapp.di

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.facedetectorapp.R
import com.example.facedetectorapp.repository.MainRepo
import com.example.facedetectorapp.repository.MainRepoImpl
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetector
import com.google.mlkit.vision.face.FaceDetectorOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FaceDetectorModule {

    @Provides
    @Singleton
    fun provideFaceDetectorOptions(): FaceDetectorOptions{
        return FaceDetectorOptions.Builder()
            .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_ACCURATE)
            .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_ALL)
            .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
            .setContourMode(FaceDetectorOptions.CONTOUR_MODE_ALL)
            .build()
    }

    @Provides
    @Singleton
    fun faceDetector(
        options: FaceDetectorOptions
    ): FaceDetector{
        return FaceDetection.getClient(options)
    }


    @Provides
    @Singleton
    fun provideRepo(mainRepoImpl: MainRepoImpl): MainRepo{
        return mainRepoImpl
    }

    @Provides
    @Singleton
    fun provideNotificationBuilder(
        @ApplicationContext context: Context
    ): NotificationCompat.Builder{
        return NotificationCompat.Builder(context,"Face_Detector_Notification")
            .setContentTitle("Start Scanning")
            .setContentText("Are you Ready to Scan Your Face")
            .setSmallIcon(R.drawable.img)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
    }

    @Provides
    @Singleton
    fun provideNotificationManager(
        @ApplicationContext context: Context
    ): NotificationManagerCompat {
        val notificationManager = NotificationManagerCompat.from(context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            val channel = NotificationChannel(
                "Face_Detector_Notification",
                "Face Detector Notification",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }
        return notificationManager
    }



}