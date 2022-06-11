package com.example.ethereum_blockchain.data.model.response

import com.google.gson.annotations.SerializedName


data class Outputs (

  @SerializedName("value"     ) var value     : Int?              = null,
  @SerializedName("script"    ) var script    : String?           = null,
  @SerializedName("addresses" ) var addresses : ArrayList<String> = arrayListOf()

)