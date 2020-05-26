package com.example.mesplats.ui.recipe.addRecipe

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mesplats.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import java.util.Arrays.copyOf
import java.util.EnumSet.copyOf
import kotlin.collections.ArrayList


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

        //bouton ajout ingredient
        val button_create_ingredient: Button = rootview.findViewById(R.id.button_create_ingredient)
        val text: EditText = rootview.findViewById(R.id.textInputEditText_ingredientName)
        button_create_ingredient.setOnClickListener {
            val ingredientName = text.text.toString()
            val checkIfExists = ingredientDao.findByName(ingredientName)

            if (checkIfExists.isEmpty()){
                val ingredient = Ingredient(ingredientName)
                ingredientDao.insert(ingredient)
                ingredients.add(ingredient)
                recyclerView.adapter?.notifyDataSetChanged()

                ingredientAdapter.quantities.append(0)
            } else { Toast.makeText(context, "Cet ingrédient existe déjà", Toast.LENGTH_SHORT).show() }
            val a: Activity? = activity
            (a as MainActivity).hideKeyboard()
        }

        //test base de données
        ingredientDao = AppDatabase.getAppDatabase(context as FragmentActivity?)
            .getIngredientDAO()
//        ingredientDao.deleteAll()
        ingredientDao.insert(Ingredient("Pommes"))
        ingredientDao.insert(Ingredient("Oeufs"))
        ingredientDao.insert(Ingredient("Semoule"))
        ingredientDao.insert(Ingredient("Huile"))

        Log.i("MyfragmentRecipe", ingredientDao.getAll().toString())

        //liste ingrédients
        ingredients = ingredientDao.getAll() as ArrayList<Ingredient>
        ingredientAdapter = IngredientAdapter(ingredients)
        val quantities: IntArray = ingredientAdapter.quantities
        recyclerView = rootview.findViewById<View>(R.id.ingredientsRecyclerView) as RecyclerView
        val layourManager = LinearLayoutManager(context)
        layourManager.orientation = LinearLayoutManager.VERTICAL;
        recyclerView.layoutManager = layourManager
        recyclerView.adapter = ingredientAdapter

        // Buton ajou recette
        val fab: FloatingActionButton = rootview.findViewById(R.id.f_addrecipe_fab)
        fab.setOnClickListener {
            for (quantity in quantities) {
                Log.i("quantities", quantity.toString())
            }
        }


        return rootview
    }
}
