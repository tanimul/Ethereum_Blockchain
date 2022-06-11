package com.example.ethereum_blockchain.ui

import android.content.Intent
import android.os.Bundle
import com.example.ethereum_blockchain.databinding.ActivityInputBinding
import com.example.ethereum_blockchain.utils.extentions.toast

class InputActivity : AppBaseActivity() {
    companion object {
        private const val TAG: String = "InputActivity"
    }

    private lateinit var binding: ActivityInputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

//binding.etAddress.text.toString()
        binding.btnShow.setOnClickListener {
            if (binding.etAddress.text.toString().isNotEmpty()) {
                startActivity(
                    Intent(this, InfoActivity::class.java).putExtra(
                        "address", "738d145faabb1e00cf5a017588a9c0f998318012"
                    )
                )
            } else {
                toast("Please Put address.")
            }
        }


    }
}