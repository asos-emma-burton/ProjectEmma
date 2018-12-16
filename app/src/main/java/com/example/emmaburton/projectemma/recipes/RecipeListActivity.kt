package com.example.emmaburton.projectemma.recipes

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.example.emmaburton.projectemma.R
import com.example.emmaburton.projectemma.data.services.RecipesApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_recipe_list.*

class RecipeListActivity : FragmentActivity() {

    private val api = RecipesApi()
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_recipe_list)

        search_results_recycler_view.layoutManager = GridLayoutManager(this, 1)

        compositeDisposable.add(api.getAllRecipes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { search_results_recycler_view.adapter = RecipesAdapter(it) },
                        { Log.d(javaClass.simpleName, "Error getting the recipes", it) }
                ))

    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

}
