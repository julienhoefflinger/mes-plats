package com.example.mesplats.ui.recipe.addRecipe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mesplats.AppDatabase
import com.example.mesplats.Ingredient
import com.example.mesplats.IngredientDao
import com.example.mesplats.R


class AddRecipeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var ingredients: ArrayList<Ingredient>
    private var ingredient  = ArrayList<Ingredient>()
    private lateinit var ingredientAdapter: IngredientAdapter
    private lateinit var ingredientDao: IngredientDao

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.fragment_addrecipe, container, false)



        //bouton ajout recette
        val button_create_ingredient: Button = rootview.findViewById(R.id.button_create_ingredient)
//        val text: EditText = rootview.findViewById(R.id.textInputEditText_ingredientName)
        button_create_ingredient.setOnClickListener {
//            val name = text.text.toString()
            val ingredient: Ingredient = Ingredient("name")
            ingredientDao.insert(ingredient)
            ingredients.add(ingredient)
            recyclerView.adapter?.notifyDataSetChanged()
        }

        //test base de données
        ingredientDao = AppDatabase.getAppDatabase(context as FragmentActivity?)
            .getIngredientDAO()
        ingredientDao.deleteAll()
        ingredientDao.insert(Ingredient("Pommes"))
        ingredientDao.insert(Ingredient("Oeufs"))
        ingredientDao.insert(Ingredient("Semoule"))

        Log.i("MyfragmentRecipe", ingredientDao.getAll().toString())

        //liste ingrédients
        ingredients = ingredientDao.getAll() as ArrayList<Ingredient>
        val adapter = IngredientAdapter(ingredients)
        Log.i("MyfragmentRecipe", adapter.getItemCount().toString())
        recyclerView = rootview.findViewById<View>(R.id.ingredientsRecyclerView) as RecyclerView
        val layourManager = LinearLayoutManager(context)
        layourManager.orientation = LinearLayoutManager.VERTICAL;
        recyclerView.layoutManager = layourManager
        recyclerView.adapter = adapter

        return rootview
    }
}
