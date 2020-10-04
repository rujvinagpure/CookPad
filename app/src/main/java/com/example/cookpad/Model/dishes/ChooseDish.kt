package com.example.cookpad.Model.dishes

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.cookpad.Model.dishes.Meal

class ChooseDish {
    @SerializedName("meals")
    @Expose
    var meals: List<Meal>? = null

}