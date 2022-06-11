package com.example.ethereum_blockchain.data.model.response

import com.google.gson.annotations.SerializedName

data class Txs (

  @SerializedName("block_hash") val block_hash : String,
  @SerializedName("block_height") val block_height : Int,
  @SerializedName("block_index") val block_index : Int,
  @SerializedName("hash") val hash : String,
  @SerializedName("addresses") val addresses : List<String>,
  @SerializedName("total") val total : Double,
  @SerializedName("fees") val fees : Double,
  @SerializedName("size") val size : Int,
  @SerializedName("gas_limit") val gas_limit : Int,
  @SerializedName("gas_used") val gas_used : Int,
  @SerializedName("gas_price") val gas_price : Double,
  @SerializedName("gas_tip_cap") val gas_tip_cap : Double,
  @SerializedName("gas_fee_cap") val gas_fee_cap : Double,
  @SerializedName("confirmed") val confirmed : String,
  @SerializedName("received") val received : String,
  @SerializedName("ver") val ver : Int,
  @SerializedName("double_spend") val double_spend : Boolean,
  @SerializedName("vin_sz") val vin_sz : Int,
  @SerializedName("vout_sz") val vout_sz : Int,
  @SerializedName("internal_txids") val internal_txids : List<String>,
  @SerializedName("confirmations") val confirmations : Int,
  @SerializedName("confidence") val confidence : Int,
  @SerializedName("inputs") val inputs : List<Inputs>,
  @SerializedName("outputs") val outputs : List<Outputs>
)