package com.example.ethereum_blockchain.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ethereum_blockchain.data.model.response.Response_Model
import com.example.ethereum_blockchain.data.repository.InfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InfoViewModel : ViewModel() {
    private val repository: InfoRepository = InfoRepository()
    val infos = MutableLiveData<Response_Model>()

    fun getInfos(address: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (repository.getInfos(address).body() != null) {
                infos.postValue(repository.getInfos(address).body())
            }
        }
    }

}