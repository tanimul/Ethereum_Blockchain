package com.example.ethereum_blockchain.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.ethereum_blockchain.databinding.ActivityInputBinding
import com.example.ethereum_blockchain.utils.Constants.request_code
import com.example.ethereum_blockchain.utils.extentions.toast


class InputActivity : AppBaseActivity() {
    companion object {
        private const val TAG: String = "InputActivity"
    }

    private lateinit var binding: ActivityInputBinding
    private lateinit var codeScanner: CodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (ContextCompat.checkSelfPermission(
                applicationContext,
                android.Manifest.permission.CAMERA
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.CAMERA),
                request_code
            )
        }

        codeScanner = CodeScanner(this, binding.viewQrScanner)

        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.formats = CodeScanner.ALL_FORMATS
        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.scanMode = ScanMode.SINGLE
        codeScanner.isAutoFocusEnabled = true
        codeScanner.isFlashEnabled = false

        // Callbacks
        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                Log.d(TAG, "onCreate: ${it.text}")
                startActivity(
                    Intent(this, InfoActivity::class.java).putExtra(
                        "address", it.text
                    )
                )
            }
        }
        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
            runOnUiThread {
                toast("Camera initialization error: ${it.message}")
            }
        }

        /*Test Purpose public address
        738d145faabb1e00cf5a017588a9c0f998318012
        0x9faaaaf9e2d101db242ecb23b833cd5f82b92cdc
        0x77EdD9eF8D639bE078507e79c3D2DBb5e513c839
        */

        binding.btnShow.setOnClickListener {
            if (binding.etAddress.text.toString().isNotEmpty()) {
                startActivity(
                    Intent(this, InfoActivity::class.java).putExtra(
                        "address", binding.etAddress.text.toString()
                    )
                )

            } else {
                toast("Please Put Public key address.")
            }
        }

    }

    override fun onResume() {
        super.onResume()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == request_code) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                toast("Permission granted")
                codeScanner.startPreview()
            } else {
                toast("Permission denied")
            }
        }
    }

}