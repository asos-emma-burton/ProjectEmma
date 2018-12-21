package com.example.emmaburton.projectemma.recipes

import com.example.emmaburton.projectemma.TestSchedulerProvider
import com.example.emmaburton.projectemma.entities.Recipe
import com.example.emmaburton.projectemma.logger.Logger
import com.example.emmaburton.projectemma.services.RecipesService
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import org.junit.Test
import java.io.IOException

class RecipesPresenterTest {

    private val recipesService: RecipesService = mock()
    private val recipesView: RecipesView = mock()
    private val logger: Logger = mock()

    private val presenter = RecipesPresenter(recipesService, recipesView, TestSchedulerProvider(), logger)

    @Test
    fun givenServiceReturnsRecipes_whenResumed_thenRecipesSentToView() {
        val recipes = listOf<Recipe>()
        given(recipesService.fetchRecipes()).willReturn(Observable.just(recipes))

        presenter.onResume()

        verify(recipesView).renderRecipes(recipes)
    }

    @Test
    fun givenServiceThrowsError_whenResumed_thenErrorLogged() {
        val ioException = IOException()

        given(recipesService.fetchRecipes()).willReturn(Observable.error(ioException))

        presenter.onResume()

        verify(logger).e(any(), any(), eq(ioException))
    }

}