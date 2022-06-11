package com.example.ethereum_blockchain.ui

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.ethereum_blockchain.databinding.ActivityInfoBinding
import com.example.ethereum_blockchain.utils.extentions.isNetworkAvailable
import com.example.ethereum_blockchain.utils.extentions.toast
import com.example.ethereum_blockchain.viewmodel.InfoViewModel

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

        if(isNetworkAvailable()){
            showProgress(true)
            infoViewModel.getInfos(address)

            infoViewModel.infos.observe(this) {
                Log.d(TAG, "Data Observed: $it")
                showProgress(false)
            }
        }else{
            showProgress(false)
            toast("Please Connect Your Internet")
        }

    }
}