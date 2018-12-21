package com.example.emmaburton.projectemma.recipes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.emmaburton.projectemma.R
import com.example.emmaburton.projectemma.entities.Recipe
import kotlinx.android.synthetic.main.item_recipe.view.*

class RecipesAdapter(private val recipeList: List<Recipe>) :
        RecyclerView.Adapter<RecipesAdapter.ViewHolder>() {

    override fun getItemCount() = recipeList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.recipe_image.setImageURI(recipeList[position].imageURL)
        holder.itemView.recipe_title.text = recipeList[position].name

        holder.itemView.setOnClickListener { expandRecipeCard(position) }
    }

    private fun expandRecipeCard(position: Int) {
        //todo implement method
    }
    
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}