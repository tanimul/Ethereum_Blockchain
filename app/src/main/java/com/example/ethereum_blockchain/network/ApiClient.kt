package com.example.ethereum_blockchain.network

import com.example.ethereum_blockchain.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {
    companion object {
        var retrofit: Retrofit? = null
        lateinit var apiInterface: ApiInterface
        fun getClient(): ApiInterface {
            if (retrofit == null) {
                synchronized(this) {
                    retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                    apiInterface = retrofit!!.create(ApiInterface::class.java)
                }
            }
            return apiInterface
        }
    }

}