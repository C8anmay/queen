package com.ypp.retrofit_api.API

import com.ypp.retrofit_api.model.QueenItem
import retrofit2.Call
import retrofit2.http.GET

interface QueenInterface{
    @GET("queen")
    fun getPost():Call<ArrayList<QueenItem>>

}