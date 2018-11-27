package com.example.emmaburton.projectemma

import com.google.gson.annotations.SerializedName

data class Post (
        @SerializedName("name") val name: String
)