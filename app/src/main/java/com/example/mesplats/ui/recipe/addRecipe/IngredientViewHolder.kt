package com.example.mesplats.ui.recipe.addRecipe

import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mesplats.R

class IngredientViewHolder (rootView: View) : RecyclerView.ViewHolder(rootView) {
    var ingredientName: TextView
//    var restaurantZone: TextView
//    var restaurantImage: ImageView
//    var openDetail: TextView

    init {
        this.ingredientName = rootView.findViewById(R.id.f_row_ingredient_title)
//        this.restaurantZone = rootView.findViewById(R.id.f_row_crous_restaurant_zone)
//        this.restaurantImage = rootView.findViewById(R.id.f_row_crous_restaurant_type)
//        this.openDetail = rootView.findViewById(R.id.f_row_crous_restaurant_titre)
//        this.openDetail.setOnClickListener {
//            onItemClickListener.onItemClick(null, it, adapterPosition, 0L)
//        }
    }
}
