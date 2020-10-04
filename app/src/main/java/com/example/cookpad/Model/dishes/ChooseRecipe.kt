package com.example.cookpad.Model.dishes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ChooseRecipe {
    @SerializedName("meals")
    @Expose
    var meals: List<Recipe>? = null

}