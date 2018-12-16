package com.example.emmaburton.projectemma.data.api

import com.example.emmaburton.projectemma.entities.Recipe
import io.reactivex.Observable
import retrofit2.http.GET

interface RecipeApiInterface {

    @GET("recipes.json")
    fun getAllRecipes(): Observable<List<Recipe>>

}