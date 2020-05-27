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
    private lateinit var ingredientAdapter: IngredientAdapter
    private var ingredientDao: IngredientDao = AppDatabase.getAppDatabase(context as FragmentActivity?).getIngredientDAO()
    private var ingredients: ArrayList<Ingredient> = ingredientDao.getAll() as ArrayList<Ingredient>
    private var quantities: Hashtable<String, IngredientAdapter.IngredientFull> = Hashtable<String, IngredientAdapter.IngredientFull>(ingredients.size)

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.fragment_addrecipe, container, false)


        //test base de données
        ingredientDao.insert(Ingredient("Pommes"))
        ingredientDao.insert(Ingredient("Oeufs"))
        ingredientDao.insert(Ingredient("Semoule"))
        ingredientDao.insert(Ingredient("Huile"))

        Log.i("MyfragmentRecipe", ingredientDao.getAll().toString())


        //liste ingrédients
//        for (x in 0..ingredients.size-1){
//            quantities.put(
//                ingredients.get(x).name,
//                IngredientAdapter.IngredientFull(
//                    0,
//                    ""
//                )
//            )
//        }

        ingredientAdapter = IngredientAdapter(ingredients, quantities)
        recyclerView = rootview.findViewById<View>(R.id.ingredientsRecyclerView) as RecyclerView
        val layourManager = LinearLayoutManager(context)
        layourManager.orientation = LinearLayoutManager.VERTICAL;
        recyclerView.layoutManager = layourManager
        recyclerView.adapter = ingredientAdapter

        // Bouton ajout recette
        val fab: FloatingActionButton = rootview.findViewById(R.id.f_addrecipe_fab)
        fab.setOnClickListener {
            val recipeName = rootview.findViewById<View>(R.id.textInputEditText)
            for (quantity in quantities) {
                Log.i("ingredient name : ", quantity.key)
                Log.i("quantities", quantity.value.quantity.toString())
                Log.i("unit", quantity.value.unit)
                Log.i("", "")
            }
        }



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

                quantities.put(
                    ingredientName,
                    IngredientAdapter.IngredientFull(
                        0,
                        ""
                    )
                )
            } else { Toast.makeText(context, "Cet ingrédient existe déjà", Toast.LENGTH_SHORT).show() }
            val a: Activity? = activity
            (a as MainActivity).hideKeyboard()
        }

        return rootview
    }
}
