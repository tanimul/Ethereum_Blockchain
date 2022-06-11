package com.example.ethereum_blockchain.network

import com.example.ethereum_blockchain.data.model.response.Response_Model
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("eth/main/addrs/{address}/full")
    suspend fun getInfo(@Path("address") address: String): Response<Response_Model>

}