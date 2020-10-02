package com.example.cookpad

import com.google.gson.JsonObject

interface ApiResult {
    fun onError(e: Exception)

    fun onModel(baseModel: BaseModel)

    fun onJson(jsonObject: JsonObject)

    fun onAPIFail()

}