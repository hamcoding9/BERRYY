package com.hamcoding.berryy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hamcoding.berryy.R
import com.hamcoding.berryy.databinding.FragmentLauncherBinding

class LauncherFragment : Fragment() {

    private var _binding: FragmentLauncherBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLauncherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val isOnBoarding = true
//        if (isOnBoarding) {
//            findNavController().navigate(R.id.action_launcherFragment_to_onBoardingFragment)
//        } else {
//            findNavController().navigate(R.id.action_launcherFragment_to_navigation_home)
//        }
        binding.btnOnboarding.setOnClickListener {
            findNavController().navigate(R.id.action_launcherFragment_to_onBoardingFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}