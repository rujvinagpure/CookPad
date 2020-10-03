package com.example.cookpad.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("categories")
    @Expose
    var categories: List<Category>? = null

}