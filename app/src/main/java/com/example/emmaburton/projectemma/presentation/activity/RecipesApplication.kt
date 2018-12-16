package com.example.emmaburton.projectemma.presentation.activity

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

@Suppress("unused")
class RecipesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)
    }

}