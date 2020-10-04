package com.example.cookpad.Model

import com.example.cookpad.Model.dishes.ChooseDish
import com.example.cookpad.Model.dishes.ChooseRecipe
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("categories.php/")
    fun getCategory(): Call<User?>?

    @GET("filter.php")
    fun getDishes(@Query("c") c : String): Call<ChooseDish>
    @GET("lookup.php")
    fun getRecipe(@Query("i") i : Int) :Call<ChooseRecipe>
}