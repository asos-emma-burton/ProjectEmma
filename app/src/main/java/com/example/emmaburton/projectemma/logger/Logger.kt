package com.example.emmaburton.projectemma.logger

interface Logger {

    fun e(tag: String, message: String, throwable: Throwable)
}