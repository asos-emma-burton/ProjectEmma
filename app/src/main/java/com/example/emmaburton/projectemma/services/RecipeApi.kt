package com.example.emmaburton.projectemma.services

import com.example.emmaburton.projectemma.entities.Recipe
import io.reactivex.Single
import retrofit2.http.GET

interface RecipeApi {

    @GET("recipes.json")
    fun getAllRecipes(): Single<List<Recipe>>

}