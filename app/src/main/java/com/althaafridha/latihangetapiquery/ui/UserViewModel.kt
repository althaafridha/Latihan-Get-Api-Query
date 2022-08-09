package com.althaafridha.latihangetapiquery.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.althaafridha.latihangetapiquery.data.Users
import com.althaafridha.latihangetapiquery.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel: ViewModel() {
	private val listUser = MutableLiveData<Users>()

//	fungsi buat search
	fun searchUserApi(username: String){
		ApiConfig.getApiService().searchUser(username).enqueue(object : Callback<Users>{
			override fun onResponse(call: Call<Users>, response: Response<Users>) {
				listUser.value = response.body()
			}

			override fun onFailure(call: Call<Users>, t: Throwable) {
				Log.e("TAG", "onFailure: $t" )
			}

		})
	}

//	fungsi buat nampilin datanya
	fun getSearchUser(): LiveData<Users> = listUser


}