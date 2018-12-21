package com.example.emmaburton.projectemma.recipes

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.GridLayoutManager
import com.example.emmaburton.projectemma.R
import com.example.emmaburton.projectemma.entities.Recipe
import com.example.emmaburton.projectemma.logger.Logcat
import com.example.emmaburton.projectemma.services.RecipeServiceImpl
import com.example.emmaburton.projectemma.threading.RxSchedulerProvider
import kotlinx.android.synthetic.main.activity_recipe_list.*

class RecipeListActivity : FragmentActivity(), RecipesView {

    private val api = RecipeServiceImpl()
    private val presenter = RecipesPresenter(api, this, RxSchedulerProvider(), Logcat())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_recipe_list)

        search_results_recycler_view.layoutManager = GridLayoutManager(this, 1)
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun renderRecipes(recipes: List<Recipe>) {
        search_results_recycler_view.adapter = RecipesAdapter(recipes)
    }
}
