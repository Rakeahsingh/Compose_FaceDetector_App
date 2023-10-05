package com.example.facedetectorapp.repository


import com.google.mlkit.vision.face.FaceDetector
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class MainRepoImpl @Inject constructor(
    private val faceDetector: FaceDetector,
    
) : MainRepo {





    override fun startFaceDetector(): Flow<String?> {
        return callbackFlow {
            faceDetector

        }
    }

}