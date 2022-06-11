package com.example.ethereum_blockchain.data.model.response

import com.google.gson.annotations.SerializedName


data class Inputs (
  @SerializedName("sequence") val sequence : Int,
  @SerializedName("addresses") val addresses : List<String>
)