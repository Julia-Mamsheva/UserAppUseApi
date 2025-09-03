package com.example.userapp.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // Ключевая аннотация для инициализации Hilt
class UserApp : Application() // Наследование от Application класса