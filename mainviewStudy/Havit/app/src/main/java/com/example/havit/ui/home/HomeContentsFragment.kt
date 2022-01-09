package com.example.havit.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.havit.databinding.FragmentHomeContentsBinding

class HomeContentsFragment : Fragment() {
    private val homeContentsViewModel: HomeContentsViewModel by viewModels()
    private var _binding: FragmentHomeContentsBinding? = null
    private val binding get() = _binding!!

    private lateinit var contentsAdapter: HomeContentsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeContentsBinding.inflate(inflater, container, false)
        //homeContentsViewModel = ViewModelProvider(this).get(HomeContentsViewModel::class.java)
        binding.vmContents = homeContentsViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        initAdapter()

        return binding.root
    }

    private fun initAdapter() {
        contentsAdapter = HomeContentsAdapter()
        binding.rvContents.adapter = contentsAdapter

        homeContentsViewModel.requestContentsTaken()

        //        addAll(it)과 HomeContentsAdapter.kt에서의 setList() 함수가 같은 기능을 하나?-?
        homeContentsViewModel.contentsList.observe(viewLifecycleOwner) {
//            contentsAdapter.contentsList.addAll(it)
            contentsAdapter.setList(it)
        }

//        contentsAdapter.contentsList.addAll(
//            listOf(
//                HomeContentsData("카테고리 이름1", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
//                HomeContentsData("카테고리 이름2", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
//                HomeContentsData("카테고리 이름3", "헤더입니다", "2021.11.24"),
//                HomeContentsData("카테고리 이름4", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
//                HomeContentsData("카테고리 이름5", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
//                HomeContentsData("카테고리 이름6", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
//                HomeContentsData("카테고리 이름7", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
//                HomeContentsData("카테고리 이름8", "헤더입니다 헤더입니다 헤더입니다 헤더임", "2021.11.24"),
//            )
//        )
        contentsAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}