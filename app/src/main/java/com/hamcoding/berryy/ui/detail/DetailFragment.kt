package com.hamcoding.berryy.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.hamcoding.berryy.data.source.remote.DetailApiClient
import com.hamcoding.berryy.databinding.FragmentDetailBinding
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLayout()
    }

    private fun setLayout() {
        val adapter = DetailAdapter()
        binding.rvDetail.adapter = adapter
        binding.krxItem = args.krxItem
        lifecycleScope.launch {
            val client = DetailApiClient.create()
            val test = client.getDetailList(args.krxItem.companyCode).response.body.items.item
            adapter.submitList(test)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}