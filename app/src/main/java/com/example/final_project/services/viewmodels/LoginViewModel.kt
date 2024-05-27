package com.example.final_project.services.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.final_project.services.RetrofitServiceFactory
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

data class LoginResponse(
    @SerializedName("success")
    val success: String
)
data class LoginData(
    val email: String,
    val password: String
)
class LoginViewModel: ViewModel(){
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    private val _loginResponse = MutableStateFlow<LoginResponse>(LoginResponse(""))
    val loginResponse = _loginResponse.asStateFlow()
    fun onEmailChange(email: String){
        _email.value = email
    }
    fun onPasswordChange(password: String){
        _password.value = password
    }
    fun login(){
       viewModelScope.launch (Dispatchers.IO){
          withContext(Dispatchers.Main){
              _isLoading.value = true
            val response = RetrofitServiceFactory.makeRetrofitService.loginUser(LoginData(_email.value!!, _password.value!!))
              _loginResponse.value = LoginResponse(response.body()?.success ?: "failed")
              _isLoading.value = false
          }
       }
    }
}