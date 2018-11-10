package com.example.emmaburton.projectemma

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)

        //Set content view AFTER removing title/notification bar to avoid crash
        this.setContentView(R.layout.activity_main)

        super.onCreate(savedInstanceState)
    }
}
