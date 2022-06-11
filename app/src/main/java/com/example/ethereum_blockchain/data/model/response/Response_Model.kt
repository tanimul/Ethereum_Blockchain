package com.example.ethereum_blockchain.data.model.response

import com.google.gson.annotations.SerializedName


data class Response_Model(
    @SerializedName("address") var address: String? = null,
    @SerializedName("total_received") var totalReceived: Int? = null,
    @SerializedName("total_sent") var totalSent: Int? = null,
    @SerializedName("balance") var balance: Int? = null,
    @SerializedName("unconfirmed_balance") var unconfirmedBalance: Int? = null,
    @SerializedName("final_balance") var finalBalance: Int? = null,
    @SerializedName("n_tx") var nTx: Int? = null,
    @SerializedName("unconfirmed_n_tx") var unconfirmedNTx: Int? = null,
    @SerializedName("final_n_tx") var finalNTx: Int? = null,
    @SerializedName("nonce") var nonce: Int? = null,
    @SerializedName("pool_nonce") var poolNonce: Int? = null,
    @SerializedName("hasMore") var hasMore: Boolean? = null,
    @SerializedName("txs") var txs: ArrayList<Txs> = arrayListOf()

)