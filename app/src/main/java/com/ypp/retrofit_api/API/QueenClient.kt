package com.ypp.retrofit_api.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QueenClient{
    private val baseUrl="https://ucsmonywaonlinevote.000webhostapp.com/api/"

    private  var retrofit:Retrofit?=null
    init {
//        fun getRetrofitClient():Retrofit?{
            if (retrofit==null){
                retrofit=Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
            }
//            return retrofit }
    }
    val postApiservice=retrofit!!.create(
        QueenInterface::class.java
    )
}