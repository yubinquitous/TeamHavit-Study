package com.example.havit.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.havit.databinding.FragmentHomeContentsBinding

class HomeContentsFragment : Fragment() {
    private lateinit var viewModel: HomeContentsViewModel
    private var _binding: FragmentHomeContentsBinding? = null
    private val binding get() = _binding!!
    private lateinit var contentsAdapter: HomeContentsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(HomeContentsViewModel::class.java)
        _binding = FragmentHomeContentsBinding.inflate(inflater, container, false)

        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        contentsAdapter = HomeContentsAdapter()
        binding.rvContents.adapter = contentsAdapter
        contentsAdapter.contentsList.addAll(
            listOf(
                HomeContentsData("카테고리 이름1", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
                HomeContentsData("카테고리 이름2", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
                HomeContentsData("카테고리 이름3", "헤더입니다", "2021.11.24"),
                HomeContentsData("카테고리 이름4", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
                HomeContentsData("카테고리 이름5", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
                HomeContentsData("카테고리 이름6", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
                HomeContentsData("카테고리 이름7", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
                HomeContentsData("카테고리 이름8", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
            )
        )
        contentsAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}