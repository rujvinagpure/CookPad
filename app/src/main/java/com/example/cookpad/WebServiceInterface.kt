package com.example.cookpad

import android.database.Observable

import retrofit2.http.GET

interface WebServiceInterface {
    @GET("posts/1")
    fun getSampleData(): Observable<SampleGetModel>
}