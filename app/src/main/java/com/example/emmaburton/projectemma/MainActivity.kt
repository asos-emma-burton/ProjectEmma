package com.example.emmaburton.projectemma

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var searchText: String
    private lateinit var searchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        searchEditText = findViewById(R.id.search_edit_text)
        searchButton = findViewById(R.id.search_button)

        searchButtonClick(searchButton)

    }

    fun searchButtonClick(view: View) {
        view.setOnClickListener {

            @Override
            fun onClick() {
                searchText = searchEditText.text.toString()
            }

            println("Searching for $searchText")

        }

    }

}
