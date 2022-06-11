package com.example.ethereum_blockchain.data.model.response

import com.google.gson.annotations.SerializedName


data class Outputs (

  @SerializedName("value") val value : Double,
  @SerializedName("script") val script : String,
  @SerializedName("addresses") val addresses : List<String>

)