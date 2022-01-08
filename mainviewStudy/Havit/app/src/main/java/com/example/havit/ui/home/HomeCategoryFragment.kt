package com.example.havit.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HomeCategoryFragment : Fragment() {

    private lateinit var homeCategoryViewModel: HomeCategoryViewModel
    private var _binding: FragmentHomeCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeCategoryViewModel = ViewModelProvider(this).get(HomeCategoryViewModel::class.java)
        _binding = FragmentHomeCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}