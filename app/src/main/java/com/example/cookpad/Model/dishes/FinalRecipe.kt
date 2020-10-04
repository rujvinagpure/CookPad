package com.example.cookpad.Model.dishes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cookpad.Adapter.DishAdapter
import com.example.cookpad.Model.ApiClient
import com.example.cookpad.R
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class FinalRecipe : AppCompatActivity() {
    lateinit var apiClient: ApiClient
    lateinit var dishName:TextView
    lateinit var recipe:TextView
    lateinit var image_dish_one:ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_recipe)
        dishName=findViewById(R.id.dish_name)
        recipe=findViewById(R.id.recipe)
       image_dish_one=findViewById(R.id.image_dish_one)



        var id : String? = intent.getStringExtra("id")
        apiClient= ApiClient()
       var ruj = ApiClient.apiinterface.getRecipe(id!!.toInt())
        ruj.enqueue(object : retrofit2.Callback<ChooseRecipe?> {
            override fun onResponse(call: Call<ChooseRecipe?>, response: Response<ChooseRecipe?>) {

                Log.d("manik","working")
                dishName.text=response.body()!!.meals!!.get(0).strMeal.toString()
                recipe.text=response.body()!!.meals!!.get(0).strInstructions.toString()
                Picasso.get().load(response.body()!!.meals!!.get(0).strMealThumb).into(image_dish_one)
            }
            override fun onFailure(call: Call<ChooseRecipe?>, t: Throwable) {

                Log.d("manik", t.toString())
            }
        })


    }


}