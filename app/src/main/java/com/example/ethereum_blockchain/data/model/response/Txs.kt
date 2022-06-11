package com.example.ethereum_blockchain.data.model.response

import com.google.gson.annotations.SerializedName


data class Txs (

  @SerializedName("block_hash"     ) var blockHash     : String?            = null,
  @SerializedName("block_height"   ) var blockHeight   : Int?               = null,
  @SerializedName("block_index"    ) var blockIndex    : Int?               = null,
  @SerializedName("hash"           ) var hash          : String?            = null,
  @SerializedName("addresses"      ) var addresses     : ArrayList<String>  = arrayListOf(),
  @SerializedName("total"          ) var total         : Int?               = null,
  @SerializedName("fees"           ) var fees          : Int?               = null,
  @SerializedName("size"           ) var size          : Int?               = null,
  @SerializedName("gas_limit"      ) var gasLimit      : Int?               = null,
  @SerializedName("gas_used"       ) var gasUsed       : Int?               = null,
  @SerializedName("gas_price"      ) var gasPrice      : Int?               = null,
  @SerializedName("gas_tip_cap"    ) var gasTipCap     : Int?               = null,
  @SerializedName("gas_fee_cap"    ) var gasFeeCap     : Int?               = null,
  @SerializedName("confirmed"      ) var confirmed     : String?            = null,
  @SerializedName("received"       ) var received      : String?            = null,
  @SerializedName("ver"            ) var ver           : Int?               = null,
  @SerializedName("double_spend"   ) var doubleSpend   : Boolean?           = null,
  @SerializedName("vin_sz"         ) var vinSz         : Int?               = null,
  @SerializedName("vout_sz"        ) var voutSz        : Int?               = null,
  @SerializedName("internal_txids" ) var internalTxids : ArrayList<String>  = arrayListOf(),
  @SerializedName("confirmations"  ) var confirmations : Int?               = null,
  @SerializedName("confidence"     ) var confidence    : Int?               = null,
  @SerializedName("inputs"         ) var inputs        : ArrayList<Inputs>  = arrayListOf(),
  @SerializedName("outputs"        ) var outputs       : ArrayList<Outputs> = arrayListOf()

)