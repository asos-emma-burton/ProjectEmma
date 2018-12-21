package com.example.emmaburton.projectemma.logger

import android.util.Log

class Logcat : Logger {

    override fun e(tag: String, message: String, throwable: Throwable) {
        Log.e(tag, message, throwable)
    }
}