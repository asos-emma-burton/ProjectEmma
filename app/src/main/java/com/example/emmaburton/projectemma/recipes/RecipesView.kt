package com.example.emmaburton.projectemma.recipes

import com.example.emmaburton.projectemma.entities.Recipe

interface RecipesView {

    fun renderRecipes(recipes: List<Recipe>)

}