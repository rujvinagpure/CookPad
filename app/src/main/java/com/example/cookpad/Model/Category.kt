package com.example.cookpad.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Category {
    @SerializedName("idCategory")
    @Expose
    var idCategory: String? = null

    @SerializedName("strCategory")
    @Expose
    var strCategory: String? = null

    @SerializedName("strCategoryThumb")
    @Expose
    var strCategoryThumb: String? = null

    @SerializedName("strCategoryDescription")
    @Expose
    var strCategoryDescription: String? = null

}