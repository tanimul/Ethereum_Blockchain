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
    private lateinit var transactionList: ArrayList<Txs>
    private var address: String = ""
    private lateinit var infoAdapter: InfoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setToolbar(binding.layoutToolbar.toolbar)
        title = resources.getString(R.string.info)

        infoViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[InfoViewModel::class.java]

        transactionList = ArrayList()
        infoAdapter = InfoAdapter(transactionList)
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
                    putValue(it)
                    transactionList.addAll(it.txs)
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