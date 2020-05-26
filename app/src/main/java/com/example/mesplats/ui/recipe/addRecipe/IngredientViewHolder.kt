package com.example.mesplats.ui.recipe.addRecipe

import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.mesplats.R

class IngredientViewHolder (rootView: View) : RecyclerView.ViewHolder(rootView) {
    var ingredientName: TextView
    var ingredientQuantity: EditText
    var ingredientUnit: Spinner

    init {
        this.ingredientName = rootView.findViewById(R.id.f_row_ingredient_title)
        this.ingredientQuantity = rootView.findViewById(R.id.f_row_ingredient_quantity)
        this.ingredientUnit = rootView.findViewById(R.id.f_row_ingredient_unit_spinner)
    }
}
