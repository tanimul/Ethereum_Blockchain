package com.example.ethereum_blockchain.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ethereum_blockchain.R
import com.example.ethereum_blockchain.data.model.response.Txs
import com.example.ethereum_blockchain.databinding.LayoutTransactionBinding
import java.math.BigDecimal

class InfoAdapter(private val lists: List<Txs>) :
    RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {


    inner class InfoViewHolder(val binding: LayoutTransactionBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        return InfoViewHolder(
            LayoutTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        with(holder) {
            with(lists[position]) {
                binding.tvTotals.text =
                    holder.itemView.context.resources.getString(R.string.total) + ": " + BigDecimal(
                        total
                    ).toPlainString()
                binding.tvTime.text = received
                binding.tvSenderAddress.text =
                    holder.itemView.context.resources.getString(R.string.sender_address) + ": " + addresses[0]
                binding.tvReceiverAddress.text =
                    holder.itemView.context.resources.getString(R.string.receiver_address) + ": " + addresses[1]
            }
        }

    }

    override fun getItemCount(): Int {
        return lists.size
    }

}