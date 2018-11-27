package com.example.emmaburton.projectemma

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.results_item_layout.view.*

class ResultsRecyclerViewAdapter(private val postList: List<Post>, val context: Context) :
        RecyclerView.Adapter<ResultsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.results_item_layout, parent, false))

    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.recipe_item_title.text = postList[position].name
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}