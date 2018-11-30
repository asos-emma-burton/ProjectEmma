package com.example.emmaburton.projectemma.data.api

import com.example.emmaburton.projectemma.data.model.Recipe
import com.example.emmaburton.projectemma.presentation.activity.APP_URL
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RecipesApi {

    private lateinit var services: RecipeApiInterface

    init {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(APP_URL)
                .build()

        services = retrofit.create(RecipeApiInterface::class.java)

    }

    fun getAllRecipes(): Observable<List<Recipe>> = services.getAllRecipes().subscribeOn(Schedulers.io())

}