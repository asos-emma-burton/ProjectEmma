package com.example.emmaburton.projectemma

import com.google.gson.annotations.SerializedName

data class Recipe(
        @SerializedName("name") val name: String
)