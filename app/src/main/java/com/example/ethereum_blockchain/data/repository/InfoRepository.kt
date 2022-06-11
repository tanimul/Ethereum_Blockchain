package com.example.ethereum_blockchain.data.repository

import com.example.ethereum_blockchain.data.model.response.Response_Model
import com.example.ethereum_blockchain.network.ApiClient
import com.example.ethereum_blockchain.network.ApiInterface
import retrofit2.Response

class InfoRepository() {
    private val apiInterface: ApiInterface = ApiClient.getClient()

    suspend fun getInfos(address: String): Response<Response_Model> {
        return apiInterface.getInfo(address)
    }

}