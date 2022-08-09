package com.althaafridha.latihangetapiquery.network

import com.althaafridha.latihangetapiquery.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiConfig {
	fun getApiService(): ApiService {
		val interceptor = HttpLoggingInterceptor()
		interceptor.level = HttpLoggingInterceptor.Level.BODY

		val client = OkHttpClient.Builder()
			.readTimeout(30, TimeUnit.SECONDS)
			.addInterceptor(interceptor)
			.build()

		return Retrofit.Builder()
			.baseUrl(BuildConfig.BASE_URL)
			.client(client)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(ApiService::class.java)
	}
}