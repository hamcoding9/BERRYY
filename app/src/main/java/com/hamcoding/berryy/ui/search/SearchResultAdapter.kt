package com.hamcoding.berryy.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hamcoding.berryy.data.model.KrxItem
import com.hamcoding.berryy.databinding.ItemSearchBinding

class SearchResultAdapter(private val onStockClick: (KrxItem) -> Unit) :
    ListAdapter<KrxItem, SearchResultAdapter.ViewHolder>(diffUtil) {

    class ViewHolder(private val binding: ItemSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: KrxItem, onStockClick: (KrxItem) -> Unit) {
            binding.krxItem = item
            itemView.setOnClickListener {
                onStockClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemSearchBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position], onStockClick)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<KrxItem>() {
            override fun areItemsTheSame(oldItem: KrxItem, newItem: KrxItem): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: KrxItem, newItem: KrxItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}