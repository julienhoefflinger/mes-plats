package com.example.mesplats.ui.recipe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mesplats.AppDatabase
import com.example.mesplats.R
import com.example.mesplats.Recipe
import com.example.mesplats.RecipeDao
import com.example.mesplats.ui.recipe.addRecipe.AddRecipeFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton


const val RECIPES_ARGUMENTS_KEY = "RECIPES_ARGUMENTS_KEY"

class RecipeFragment : Fragment() {

    private lateinit var RecipeViewModel: RecipeViewModel
    private var recipes  = ArrayList<Recipe>()
    private lateinit var RecipeAdapter: RecipeAdapter
    private lateinit var recipeDao: RecipeDao

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.fragment_recipe, container, false)

        //bouton ajout recette
        val fab: FloatingActionButton = rootview.findViewById(R.id.fab)
        fab.setOnClickListener {
            val nextFrag = AddRecipeFragment()
            if (container != null) {
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.f_recipe_main_layout, nextFrag, "findThisFragment")
                    .addToBackStack(null)
                    .commit()
            }
        }


        //test base de données
        recipeDao = AppDatabase.getAppDatabase(context as FragmentActivity?)
            .getRecipeDAO()
        recipeDao.deleteAll()
        recipeDao.insert(Recipe("Tarte aux pommes"))
        recipeDao.insert(Recipe("kouglof"))
        recipeDao.insert(Recipe("couscous"))

        Log.i("MyfragmentRecipe", recipeDao.getAll().toString())


        //recyclerview
        recipes = recipeDao.getAll() as ArrayList<Recipe>

        val adapter = RecipeAdapter(recipes)
        Log.i("MyfragmentRecipe", adapter.getItemCount().toString())
        val recyclerView = rootview.findViewById<View>(R.id.f_recipe_liste_recettes) as RecyclerView
        val layourManager = LinearLayoutManager(context)
        layourManager.orientation = LinearLayoutManager.VERTICAL;
        recyclerView.layoutManager = layourManager
        recyclerView.adapter = adapter

        return rootview
    }
}
