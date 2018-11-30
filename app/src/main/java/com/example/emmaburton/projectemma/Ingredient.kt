package com.example.emmaburton.projectemma

import com.google.gson.annotations.SerializedName

data class Ingredient(
        @SerializedName("quantity") val ingredientQuantity: String,
        @SerializedName("name") val ingredientName: String,
        @SerializedName("type") val ingredientType: String
)