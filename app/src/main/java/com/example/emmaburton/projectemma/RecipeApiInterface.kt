package com.example.emmaburton.projectemma

import io.reactivex.Observable
import retrofit2.http.GET

interface RecipeApiInterface {

    @GET("name/")
    fun getAllRecipes(): Observable<List<Recipe>>
}