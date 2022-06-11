package com.example.ethereum_blockchain.data.model.response

import com.google.gson.annotations.SerializedName


data class Response_Model(
    @SerializedName("address") val address : String,
    @SerializedName("total_received") val total_received : Double,
    @SerializedName("total_sent") val total_sent : Double,
    @SerializedName("balance") val balance : Double,
    @SerializedName("unconfirmed_balance") val unconfirmed_balance : Int,
    @SerializedName("final_balance") val final_balance : Double,
    @SerializedName("n_tx") val n_tx : Int,
    @SerializedName("unconfirmed_n_tx") val unconfirmed_n_tx : Int,
    @SerializedName("final_n_tx") val final_n_tx : Int,
    @SerializedName("nonce") val nonce : Int,
    @SerializedName("pool_nonce") val pool_nonce : Int,
    @SerializedName("hasMore") val hasMore : Boolean,
    @SerializedName("txs") val txs : List<Txs>)