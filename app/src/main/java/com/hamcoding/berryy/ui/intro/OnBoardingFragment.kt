package com.hamcoding.berryy.ui.intro

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.hamcoding.berryy.R
import com.hamcoding.berryy.data.source.RankApiClient
import com.hamcoding.berryy.databinding.FragmentOnboardingBinding
import kotlinx.coroutines.launch

class OnBoardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!
    private val adapter = OnBoardingItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvOnboarding.adapter = adapter
        lifecycleScope.launch {
            val service = RankApiClient.create()
            val test = service.getRankList()
            adapter.submitList(test.body.items.rankItems)
        }
        binding.btnOnboarding.setOnClickListener {
            Log.d("온보딩", "${adapter.getSelectedItems()}")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}