package com.example.emmaburton.projectemma.services

import com.example.emmaburton.projectemma.entities.Recipe
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val RECIPE_SERVICE_URL = "http://mobile.asosservices.com/sampleapifortest/"

class RecipesApi : RecipesService {

    private var services: RecipeApiInterface

    init {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(RECIPE_SERVICE_URL)
                .build()

        services = retrofit.create(RecipeApiInterface::class.java)

    }

    override fun fetchRecipes(): Observable<List<Recipe>> =
            services.getAllRecipes().subscribeOn(Schedulers.io())

}