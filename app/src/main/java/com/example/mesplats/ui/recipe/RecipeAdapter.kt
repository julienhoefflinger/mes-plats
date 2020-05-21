package com.example.mesplats.ui.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.mesplats.R

class RecipeAdapter(private val recipe: ArrayList<Recipe>, private val onItemClickListener: AdapterView.OnItemClickListener) :
    RecyclerView.Adapter<RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(
            R.layout.row_recipe_fragment, parent,
            false)

        return RecipeViewHolder(row, onItemClickListener)
    }

    override fun onBindViewHolder(viewholder: RecipeViewHolder, position: Int) {
        val name = this.recipe[position]//.fields

        viewholder.recipeName.text = name.toString()
    }

    override fun getItemCount(): Int {
        return this.recipe.size
    }

//    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
}
