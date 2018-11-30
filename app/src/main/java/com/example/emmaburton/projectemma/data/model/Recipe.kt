package com.example.emmaburton.projectemma.data.model

import com.google.gson.annotations.SerializedName

data class Recipe(

        @SerializedName("name") val name: String,

        @SerializedName("ingredients") val ingredients: List<Ingredient>,

        @SerializedName("steps") val steps: Array<String>,

        @SerializedName("timers") val timers: Array<Int>,

        @SerializedName("imageURL") val imageURL: String,

        @SerializedName("originalURL") val originalURL: String

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Recipe

        if (!steps.contentEquals(other.steps)) return false
        if (!timers.contentEquals(other.timers)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = steps.contentHashCode()
        result = 31 * result + timers.contentHashCode()
        return result
    }
}