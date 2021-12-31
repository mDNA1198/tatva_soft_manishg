package com.manish.tatvasoft.retrofit_networking

import com.manish.tatvasoft.user_list.UserListService
import com.manish.tatvasoft.utils.AppConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofitClient: Retrofit.Builder by lazy {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())

    }

    val userListService: UserListService by lazy {
        retrofitClient.build().create(UserListService::class.java)
    }

}