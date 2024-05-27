package com.example.final_project.services

import com.example.final_project.services.viewmodels.LoginData
import com.example.final_project.services.viewmodels.LoginResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitServices{
    @POST("login")
    suspend fun loginUser(@Body loginData: LoginData): Response<LoginResponse>
}

object RetrofitServiceFactory{
    val makeRetrofitService: RetrofitServices by lazy {
        Retrofit.Builder()
            .baseUrl("http:/192.168.0.12:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitServices::class.java)
    }
}