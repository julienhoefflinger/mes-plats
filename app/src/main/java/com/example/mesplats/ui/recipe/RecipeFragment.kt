package com.example.mesplats.ui.recipe

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mesplats.AppDatabase
import com.example.mesplats.R
import com.example.mesplats.Recipe
import com.example.mesplats.RecipeDao
import com.example.mesplats.ui.recipe.addRecipe.AddRecipeFragment
import com.example.mesplats.ui.slideshow.SlideshowFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


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



        val fab: FloatingActionButton = rootview.findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            SlideShowFragment slideShowFragment = new SlideShowFragment()
            FragmentManager manager = getFragmentManager()
            manager.beginTransaction()
                .replace(R.id.f_recipe_main_layout, slideShowFragment, slideShowFragment.getTag())
                .commit()
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
