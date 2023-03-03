package com.hamcoding.berryy.ui.intro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hamcoding.berryy.data.model.RankItem
import com.hamcoding.berryy.databinding.ItemOnboardingBinding

class OnBoardingItemAdapter() : ListAdapter<RankItem, OnBoardingItemAdapter.ViewHolder>(diffUtil) {

    class ViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: RankItem) {
            binding.rankItem = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemOnboardingBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RankItem>() {
            override fun areItemsTheSame(oldItem: RankItem, newItem: RankItem): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: RankItem, newItem: RankItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}