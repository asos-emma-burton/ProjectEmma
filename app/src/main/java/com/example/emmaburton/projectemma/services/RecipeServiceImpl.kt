package com.example.emmaburton.projectemma.services

import com.example.emmaburton.projectemma.entities.Recipe
import com.google.gson.GsonBuilder
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RecipeServiceImpl : RecipeService {

    private val recipeUrl = "http://mobile.asosservices.com/sampleapifortest/"
    private var recipeApi: RecipeApi

    init {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(recipeUrl)
                .build()

        recipeApi = retrofit.create(RecipeApi::class.java)
    }

    override fun getRecipeList(): Single<List<Recipe>> =
            recipeApi.getAllRecipes().subscribeOn(Schedulers.io())
}