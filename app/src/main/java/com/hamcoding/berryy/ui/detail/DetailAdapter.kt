package com.hamcoding.berryy.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hamcoding.berryy.data.model.DividendItem
import com.hamcoding.berryy.data.model.RankItem
import com.hamcoding.berryy.databinding.ItemDetailBinding

class DetailAdapter() : ListAdapter<DividendItem, DetailAdapter.ViewHolder>(diffUtil) {

    class ViewHolder(private val binding: ItemDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DividendItem) {
            binding.dividendItem = item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemDetailBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<DividendItem>() {
            override fun areItemsTheSame(oldItem: DividendItem, newItem: DividendItem): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: DividendItem, newItem: DividendItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}