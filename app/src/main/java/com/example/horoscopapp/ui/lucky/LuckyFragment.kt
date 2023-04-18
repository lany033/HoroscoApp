package com.example.horoscopapp.ui.lucky

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import com.example.horoscopapp.R
import com.example.horoscopapp.databinding.FragmentLuckyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LuckyFragment : Fragment() {

    private val viewModel by viewModels<LuckyViewModel>()
    private var _binding: FragmentLuckyBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.tvLuckyInfo.animate().alpha(1f).duration = 1500
        val rotationCremita: Animation = AnimationUtils.loadAnimation(requireContext(),R.anim.rotatito)
        binding.tvLuckyInfo.startAnimation(rotationCremita)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLuckyBinding.inflate(inflater, container, false)
        return binding.root
    }

}