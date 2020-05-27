package com.example.mesplats.ui.recipe.addRecipe

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.mesplats.Ingredient
import com.example.mesplats.R
import java.util.*


class IngredientAdapter(private val ingredient: ArrayList<Ingredient>, private var quantities: Hashtable<String, IngredientFull>) :
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
//                quantities[viewholder.getAdapterPosition()] =
//                    viewholder.ingredientQuantity.getText().toString().toInt()
                var quantity = viewholder.ingredientQuantity.getText().toString()
                if (quantity == "" || quantity.toInt() == 0) {
                    if(quantities.containsKey(viewholder.ingredientName.text as String)){
                        quantities.remove(viewholder.ingredientName.text as String)
                    }
                }
                else {
                    if(quantities.containsKey(viewholder.ingredientName.text as String)){
                        quantities[viewholder.ingredientName.text as String] =
                            IngredientFull(
                                quantity.toInt(),
                                viewholder.ingredientUnit.getSelectedItem().toString()
                            )
                    } else {
                        quantities.put(
                            viewholder.ingredientName.text as String,
                            IngredientFull(
                                quantity.toInt(),
                                viewholder.ingredientUnit.getSelectedItem().toString()
                            )
                        )
                    }
                }


//                quantities.set(position, viewholder.ingredientQuantity.getText().toString().toInt())
            }

            override fun afterTextChanged(s: Editable) {}
        })



        viewholder.ingredientUnit.setOnItemSelectedListener(object : OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                var quantity = viewholder.ingredientQuantity.getText().toString()
                if (quantity == "" || quantity.toInt() == 0) {
                    if(quantities.containsKey(viewholder.ingredientName.text as String)){
                        quantities.remove(viewholder.ingredientName.text as String)
                    }
                }
                else {
                    if(quantities.containsKey(viewholder.ingredientName.text as String)){
                        quantities[viewholder.ingredientName.text as String] =
                            IngredientFull(
                                quantity.toInt(),
                                viewholder.ingredientUnit.getSelectedItem().toString()
                            )
                    } else {
                        quantities.put(
                            viewholder.ingredientName.text as String,
                            IngredientFull(
                                quantity.toInt(),
                                viewholder.ingredientUnit.getSelectedItem().toString()
                            )
                        )
                    }
                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
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

    class IngredientFull(val quantity: Int, val unit: String){

    }
}
