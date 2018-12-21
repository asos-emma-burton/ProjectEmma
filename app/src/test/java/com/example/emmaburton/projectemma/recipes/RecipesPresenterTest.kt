package com.example.emmaburton.projectemma.recipes

import com.example.emmaburton.projectemma.TestSchedulerProvider
import com.example.emmaburton.projectemma.entities.Recipe
import com.example.emmaburton.projectemma.logger.Logger
import com.example.emmaburton.projectemma.services.RecipeService
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Single
import org.junit.Test
import java.io.IOException

class RecipesPresenterTest {

    private val recipesServiceInterface: RecipeService = mock()
    private val recipesView: RecipesView = mock()
    private val logger: Logger = mock()

    private val presenter = RecipesPresenter(recipesServiceInterface, recipesView, TestSchedulerProvider(), logger)

    @Test
    fun givenServiceReturnsRecipes_whenResumed_thenRecipesSentToView() {
        val recipes = listOf<Recipe>()
        given(recipesServiceInterface.getRecipeList()).willReturn(Single.just(recipes))

        presenter.onResume()

        verify(recipesView).renderRecipes(recipes)
    }

    @Test
    fun givenServiceThrowsError_whenResumed_thenErrorLogged() {
        val ioException = IOException()

        given(recipesServiceInterface.getRecipeList()).willReturn(Single.error(ioException))

        presenter.onResume()

        verify(logger).e(any(), any(), eq(ioException))
    }

}