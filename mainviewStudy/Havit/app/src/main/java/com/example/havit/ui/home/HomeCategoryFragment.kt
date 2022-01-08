package com.example.havit.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.havit.databinding.FragmentHomeCategoryBinding

class HomeCategoryFragment : Fragment() {

    private lateinit var homeCategoryViewModel: HomeCategoryViewModel
    private var _binding: FragmentHomeCategoryBinding? = null
    private val binding get() = _binding!!
    private lateinit var categoryAdapter: HomeCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        homeCategoryViewModel = ViewModelProvider(this).get(HomeCategoryViewModel::class.java)
        _binding = FragmentHomeCategoryBinding.inflate(inflater, container, false)

        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        categoryAdapter = HomeCategoryAdapter()
        binding.rvCategory.adapter = categoryAdapter
        categoryAdapter.categoryList.addAll(
            listOf(
                HomeCategoryData("UX/UI 아티클", 28),
                HomeCategoryData("UX/UI 아티클", 28),
                HomeCategoryData("UX/UI 아티클", 28),
                HomeCategoryData("UX/UI 아티클", 28),
                HomeCategoryData("UX/UI 아티클", 28),
                HomeCategoryData("UX/UI 아티클", 28),
                HomeCategoryData("UX/UI 아티클", 28)
            )
        )
        categoryAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}