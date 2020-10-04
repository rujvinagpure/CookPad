package com.example.cookpad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookpad.Adapter.CategoryAdapter
import com.example.cookpad.Model.ApiClient
import com.example.cookpad.Model.Category
import com.example.cookpad.Model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealCategory : AppCompatActivity() {

    lateinit var apiclient: ApiClient
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_category)

        apiclient = ApiClient()
        recyclerView = findViewById(R.id.recyclerthing)
        val call =
            ApiClient.apiinterface.getCategory()
        call!!.enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {

                Log.d("manik","working")

                var categoryAdapter:CategoryAdapter = CategoryAdapter(applicationContext,response.body()!!)
                recyclerView.adapter = categoryAdapter
                recyclerView.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {

                Log.d("manik", t.toString())
            }
        })
    }
}