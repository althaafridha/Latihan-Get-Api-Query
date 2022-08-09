package com.althaafridha.latihangetapiquery.network

import com.althaafridha.latihangetapiquery.data.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

	@GET("search/users")
	@Headers("Authorization: token //token")
	fun searchUser(@Query("q") username: String): Call<Users>
}