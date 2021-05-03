package com.example.latihanapiget

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/kota_kab/k69.json?print=pretty")
    fun getKodePos(): Call<ArrayList<KodeposModel>>
}