package com.example.mesplats.ui.recipe

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mesplats.R

const val RECIPES_ARGUMENTS_KEY = "RECIPES_ARGUMENTS_KEY"

class RecipeFragment : Fragment() {

    private lateinit var RecipeViewModel: RecipeViewModel
    private var recipes  = ArrayList<Recipe>()
    private lateinit var RecipeAdapter: RecipeAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        //recipes = arguments!!.getSerializable(RECIPES_ARGUMENTS_KEY) as ArrayList<Recipe>;

        val rootview = inflater.inflate(R.layout.fragment_recipe, container, false)

        val listerecipes = rootview.findViewById<RecyclerView>(R.id.f_recipe_liste_recettes)
//        RecipeAdapter = RecipeAdapter(recipes,
//            AdapterView.OnItemClickListener {
//                    parent, view, position, id ->
//                val intent = Intent(context, InfoActivity::class.java)
//                intent.putExtra("EXTRA_Recipe", recipes.get(position))
//                this.startActivity(intent)
//            })
//        listerecipes.adapter = RecipeAdapter
        listerecipes.layoutManager = LinearLayoutManager(context)


        //RecipeViewModel = ViewModelProviders.of(this).get(RecipeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_recipe, container, false)
//        val textView: TextView = root.findViewById(R.id.text_recipe)
//        RecipeViewModel.text.observe(viewLifecycleOwner, Observer {
////            textView.text = it
////        })
        return root
    }
}