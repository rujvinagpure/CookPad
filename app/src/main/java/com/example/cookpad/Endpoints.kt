package com.example.cookpad

import retrofit2.Call
import retrofit2.http.GET

interface Endpoints {
    @GET("posts")
    fun getPosts():Call< >

}