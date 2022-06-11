package com.example.ethereum_blockchain.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.ethereum_blockchain.R
import com.example.ethereum_blockchain.data.model.response.Response_Model
import com.example.ethereum_blockchain.databinding.ActivityInfoBinding
import com.example.ethereum_blockchain.utils.extentions.isNetworkAvailable
import com.example.ethereum_blockchain.utils.extentions.toast
import com.example.ethereum_blockchain.viewmodel.InfoViewModel
import java.math.BigDecimal

class InfoActivity : AppBaseActivity() {
    companion object {
        private const val TAG: String = "InfoActivity"
    }

    private lateinit var binding: ActivityInfoBinding
    private lateinit var infoViewModel: InfoViewModel
    private var address: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        infoViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[InfoViewModel::class.java]

        if (intent != null) {
            address = intent.getStringExtra("address").toString()
        }

        if (isNetworkAvailable()) {
            showProgress(true)
            infoViewModel.getInfos(address)
            infoViewModel.infos.observe(this) {
                Log.d(TAG, "Data Observed: $it")
                showProgress(false)
                putValue(it)
            }
        } else {
            showProgress(false)
            toast("Please Connect Your Internet")
        }

    }

    private fun putValue(it: Response_Model) {
        binding.tvTotalBalance.text = BigDecimal(it.balance).toPlainString()
        binding.tvTotalSendBalance.text = BigDecimal(it.total_sent).toPlainString()
        binding.tvTotalReceivedBalance.text = BigDecimal(it.total_received).toPlainString()
        binding.tvTotalNonce.text =
            resources.getString(R.string.total_nonce) + " " + it.nonce.toString()
    }
}