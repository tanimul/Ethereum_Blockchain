package com.example.ethereum_blockchain

import android.app.Application

class App : Application() {
    override fun onCreate() {
        instance = this
        super.onCreate()
    }

    companion object {
        private lateinit var instance: App
        fun getInstance(): App {
            return instance
        }
    }

}