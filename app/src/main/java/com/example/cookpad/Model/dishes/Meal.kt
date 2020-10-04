package com.example.cookpad.Model.dishes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Meal {
    @SerializedName("strMeal")
    @Expose
    var strMeal: String? = null

    @SerializedName("strMealThumb")
    @Expose
    var strMealThumb: String? = null

    @SerializedName("idMeal")
    @Expose
    var idMeal: String? = null


}