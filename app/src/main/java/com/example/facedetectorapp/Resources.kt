package com.example.facedetectorapp

sealed class Resources<T>(val Data: T? = null, val mesage: String? = null){

    class Success<T>(Data: T): Resources<T>(Data)
    class Error<T>(mesage: String, Data: T? = null): Resources<T>(Data, mesage)
    class Loading<T>(Data: T? = null): Resources<T>(Data)

}
