package com.example.ethereum_blockchain.ui

import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ethereum_blockchain.R
import com.example.ethereum_blockchain.adapter.InfoAdapter
import com.example.ethereum_blockchain.data.model.response.Response_Model
import com.example.ethereum_blockchain.data.model.response.Txs
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
    private lateinit var transaction_list: ArrayList<Txs>
    private var address: String = ""
    private lateinit var infoAdapter: InfoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        infoViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[InfoViewModel::class.java]

        transaction_list = ArrayList()
        infoAdapter = InfoAdapter(transaction_list);
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = infoAdapter

        if (intent != null) {
            address = intent.getStringExtra("address").toString()
        }

        if (isNetworkAvailable()) {
            showProgress(true)
            infoViewModel.getInfos(address)
            infoViewModel.infos.observe(this) {
                showProgress(false)
                Log.d(TAG, "Data Observed: $it")
                if (it != null) {
                    binding.layoutInfo.isVisible = true
                    it?.let { it1 -> putValue(it1) }
                    it?.let { it1 -> transaction_list.addAll(it1.txs) }
                    infoAdapter.notifyDataSetChanged()
                } else {
                    binding.layoutInfo.isVisible = false
                    binding.tvNoData.isVisible = true
                }

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
            resources.getString(R.string.total_nonce) + ": " + it.nonce.toString()
        binding.tvTotalTransaction.text =
            resources.getString(R.string.total_transaction) + ": " + it.txs.size

    }
}