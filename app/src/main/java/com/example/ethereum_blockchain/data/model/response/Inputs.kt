package com.example.ethereum_blockchain.data.model.response

import com.google.gson.annotations.SerializedName


data class Inputs (

  @SerializedName("sequence"  ) var sequence  : Int?              = null,
  @SerializedName("addresses" ) var addresses : ArrayList<String> = arrayListOf()

)