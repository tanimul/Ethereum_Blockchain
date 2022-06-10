package com.example.ethereum_blockchain.ui

import android.os.Bundle
import com.example.ethereum_blockchain.databinding.ActivityInputBinding

class InputActivity : AppBaseActivity() {
    companion object {
        private const val TAG: String = "InputActivity"
    }

    private lateinit var binding: ActivityInputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}