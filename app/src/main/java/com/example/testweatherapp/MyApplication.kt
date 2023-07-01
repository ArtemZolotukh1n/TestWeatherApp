package com.example.testweatherapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * The Application class for this Android application, integrated with Hilt for dependency injection.
 */
@HiltAndroidApp
class MyApplication(): Application()