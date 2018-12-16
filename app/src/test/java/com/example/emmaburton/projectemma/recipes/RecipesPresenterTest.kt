package com.example.emmaburton.projectemma.recipes

import com.example.emmaburton.projectemma.TestSchedulerProvider
import com.example.emmaburton.projectemma.entities.Recipe
import com.example.emmaburton.projectemma.services.RecipesService
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import org.junit.Test

class RecipesPresenterTest {

    private val recipesService: RecipesService = mock()
    private val recipesView: RecipesView = mock()

    private val presenter = RecipesPresenter(recipesService, recipesView, TestSchedulerProvider())

    @Test
    fun givenServiceReturnsRecipes_whenResumed_thenRecipesSentToView() {
        val recipes = listOf<Recipe>()
        given(recipesService.fetchRecipes()).willReturn(Observable.just(recipes))

        presenter.onResume()

        verify(recipesView).renderRecipes(recipes)
    }

}