package com.example.horoscopapp.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.horoscopapp.R
import com.example.horoscopapp.databinding.FragmentListBinding
import com.example.horoscopapp.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private val viewModel by viewModels<ListViewModel>()
    private var _binding: FragmentListBinding? = null
    private  val binding get() = _binding!!

    //listeners
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAries.setOnClickListener {
            openDetail()
        }

        binding.btnCapricornio.setOnClickListener {
            openDetail()
        }

        binding.btnLeo.setOnClickListener {
            openDetail()
        }
    }

    private fun openDetail(){
        startActivity(DetailActivity.create(requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater,container,false)
        return binding.root
    }


}