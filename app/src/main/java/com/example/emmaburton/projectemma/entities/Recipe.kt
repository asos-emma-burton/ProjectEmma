package com.example.emmaburton.projectemma.entities

data class Recipe(
        val name: String,
        val ingredients: List<Ingredient>,
        val steps: List<String>,
        val timers: List<Int>,
        val imageURL: String,
        val originalURL: String
)