package com.example.cookpad.Model

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {
    @get:GET("categories.php/")
    val getCategory: Call<User?>?
}