package com.example.final_project.services

import com.example.final_project.services.viewmodels.LoginViewModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RetrofitServices{
    @GET("login")
    suspend fun loginUser(): Response<LoginViewModel>
}

object RetrofitServiceFactory{
    val makeRetrofitService: RetrofitServices by lazy {
        Retrofit.Builder()
            .baseUrl("http:/localhost:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitServices::class.java)
    }
}