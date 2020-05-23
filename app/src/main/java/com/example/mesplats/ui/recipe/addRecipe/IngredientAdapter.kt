package com.example.mesplats.ui.recipe.addRecipe

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.mesplats.Ingredient
import com.example.mesplats.R
import com.example.mesplats.Recipe
import com.example.mesplats.ui.recipe.RecipeViewHolder

class IngredientAdapter(private val ingredient: ArrayList<Ingredient>) :
    RecyclerView.Adapter<IngredientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(
            R.layout.row_addrecipe_fragment, parent,
            false)

        return IngredientViewHolder(row)
    }

    override fun onBindViewHolder(viewholder: IngredientViewHolder, position: Int) {
        val name = this.ingredient[position].name//.fields
        viewholder.ingredientName.text = name
    }

    override fun getItemCount(): Int {
        return this.ingredient.size
    }

//    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
}
