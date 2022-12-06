package com.rahul.cryptocurrency.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rahul.cryptocurrency.R
import com.rahul.cryptocurrency.databinding.CoinListBinding
import com.rahul.cryptocurrency.domain.model.CoinListResponse

class CoinListAdapter : RecyclerView.Adapter<CoinListAdapter.CoinListViewHolder>() {

    var coinList = mutableListOf<CoinListResponse>()

    inner class CoinListViewHolder(val viewHolder: CoinListBinding) :
        RecyclerView.ViewHolder(viewHolder.root) {
        private var tvRank: TextView = viewHolder.root.findViewById(R.id.tv_rank)
        private var tvName: TextView = viewHolder.root.findViewById(R.id.tv_name)
        private var tvSymbol: TextView = viewHolder.root.findViewById(R.id.tv_symbol)
        private var tvActive: TextView = viewHolder.root.findViewById(R.id.tv_active)

        fun bind(coinListResponse: CoinListResponse) {
            tvRank.text = coinListResponse.rank.toString() + ". "
            tvName.text = coinListResponse.name + " "
            tvSymbol.text = "(" + coinListResponse.symbol + ")"
            if (coinListResponse.isActive) {
                tvActive.text = "active"
            } else {
                tvActive.text = "inactive"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinListViewHolder {
        val binding = CoinListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CoinListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinListViewHolder, position: Int) {
        holder.viewHolder.coinList = coinList[position]
        holder.bind(coinList[position])
    }

    override fun getItemCount(): Int {
        return coinList.size
    }
}