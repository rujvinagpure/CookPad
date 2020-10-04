package com.example.cookpad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookpad.Adapter.CategoryAdapter
import com.example.cookpad.Adapter.DishAdapter
import com.example.cookpad.Model.ApiClient
import com.example.cookpad.Model.User
import com.example.cookpad.Model.dishes.ChooseDish
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Dishes : AppCompatActivity() {

    lateinit var apiclient: ApiClient
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dishes)

        var name: String? = intent.getStringExtra("name")
        Log.d("okay", name!!)
        apiclient = ApiClient()
        recyclerView = findViewById(R.id.list_dishes)
        val call =
                ApiClient.apiinterface.getDishes(name.toString())

        call!!.enqueue(object : Callback<ChooseDish?> {
            override fun onResponse(call: Call<ChooseDish?>, response: Response<ChooseDish?>) {

                Log.d("manik","working")

                var diahAdapter: DishAdapter = DishAdapter(applicationContext,response.body()!!)
                recyclerView.adapter = diahAdapter
                recyclerView.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
            }

            override fun onFailure(call: Call<ChooseDish?>, t: Throwable) {

                Log.d("manik", t.toString())
            }
        })


    }
}
