package com.example.emmaburton.projectemma.services

import com.example.emmaburton.projectemma.entities.Recipe
import io.reactivex.Single

interface RecipeService {

    fun getRecipeList(): Single<List<Recipe>>

}
