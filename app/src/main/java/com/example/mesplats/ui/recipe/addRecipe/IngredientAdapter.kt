package com.example.mesplats.ui.recipe.addRecipe

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mesplats.Ingredient
import com.example.mesplats.R


class IngredientAdapter(private val ingredient: ArrayList<Ingredient>, private var quantities: ArrayList<Int>) :
    RecyclerView.Adapter<IngredientViewHolder>() {
//    var quantities: ArrayList<Int> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val row = LayoutInflater.from(parent.context).inflate(
            R.layout.row_addrecipe_fragment, parent,
            false)

//

        Log.i("ingredients", ingredient.size.toString())
        return IngredientViewHolder(row)
    }

    override fun onBindViewHolder(viewholder: IngredientViewHolder, position: Int) {
        val name = this.ingredient[position].name//.fields
        viewholder.ingredientName.text = name



        viewholder.ingredientQuantity.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
                quantities[viewholder.getAdapterPosition()] =
                    viewholder.ingredientQuantity.getText().toString().toInt()

//                quantities.set(position, viewholder.ingredientQuantity.getText().toString().toInt())
            }

            override fun afterTextChanged(s: Editable) {}
        })


    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return this.ingredient.size
    }

//    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
}
