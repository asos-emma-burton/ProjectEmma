package com.example.emmaburton.projectemma.recipes

import com.example.emmaburton.projectemma.logger.Logger
import com.example.emmaburton.projectemma.services.RecipeService
import com.example.emmaburton.projectemma.threading.SchedulerProvider
import io.reactivex.disposables.Disposable

class RecipesPresenter(
        private val recipeService: RecipeService,
        private val recipesView: RecipesView,
        private val schedulerProvider: SchedulerProvider,
        private val logger: Logger
) {

    private var recipesDisposable: Disposable? = null

    fun onResume() {
        recipesDisposable = recipeService.getRecipeList()
                .observeOn(schedulerProvider.getUiScheduler())
                .subscribe(
                        { recipes -> recipesView.renderRecipes(recipes) },
                        { throwable -> logger.e("RecipesPresenter", "Fetching recipes failed", throwable) }
                )
    }

    fun onDestroy() {
        recipesDisposable?.dispose()
    }

}