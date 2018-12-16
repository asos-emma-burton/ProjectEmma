package com.example.emmaburton.projectemma.services

import com.example.emmaburton.projectemma.entities.Recipe
import io.reactivex.Observable

interface RecipesService {

    fun fetchRecipes(): Observable<List<Recipe>>
}