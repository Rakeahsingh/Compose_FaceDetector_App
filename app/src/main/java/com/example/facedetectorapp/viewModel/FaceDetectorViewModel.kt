package com.example.facedetectorapp.viewModel


import android.annotation.SuppressLint
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.facedetectorapp.model.MainScreenState
import com.example.facedetectorapp.repository.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FaceDetectorViewModel @Inject constructor(
    private val repo: MainRepo,
    private val notificationBuilder: NotificationCompat.Builder,
    private val notificationManager: NotificationManagerCompat
): ViewModel(){

    private val _state = MutableStateFlow(MainScreenState())
    val state = _state.asStateFlow()

    @SuppressLint("MissingPermission")
    fun getNotification() {
        notificationManager.notify(1,notificationBuilder.build())
    }

    fun startFaceDetector(){
        viewModelScope.launch {
            repo.startFaceDetector().collect{ data ->
                if (!data.isNullOrBlank()){
                    _state.value = state.value.copy(
                        Details = data
                    )
                }
            }
        }
    }

}