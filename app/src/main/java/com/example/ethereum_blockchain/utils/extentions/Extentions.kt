package com.example.ethereum_blockchain.utils.extentions

import android.Manifest
import androidx.annotation.RequiresPermission
import com.example.ethereum_blockchain.App.Companion.getInstance

@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
fun isNetworkAvailable(): Boolean {
    val info = getInstance().getConnectivityManager().activeNetworkInfo
    return info != null && info.isConnected
}
