package com.example.emmaburton.projectemma

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

@Suppress("unused")
class RecipesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)
    }

}