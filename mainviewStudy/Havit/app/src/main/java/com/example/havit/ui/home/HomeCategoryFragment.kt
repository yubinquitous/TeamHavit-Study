package com.example.havit.ui.home

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.havit.databinding.FragmentHomeCategoryBinding
import kotlin.math.ceil

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

        initItemWidth()
        initAdapter()
        initIndicator()
        return binding.root
    }

    private fun initItemWidth() {
        val metrics = DisplayMetrics()


    }

    private fun initIndicator() {
        val gridIndicator = binding.anyViewIndicator2

        gridIndicator.setItemCount(categoryAdapter.itemCount / 6 + 1)   // 전체 카테고리 수 / 6 + 1
        gridIndicator.setCurrentPosition(0)

        binding.rvCategory.layoutManager =
            GridLayoutManager(context, 3, RecyclerView.HORIZONTAL, false)

//        val gridLayoutSnapHelper = GridLayoutSnapHelper(6)
//        gridLayoutSnapHelper.attachToRecyclerView(binding.rvCategory)

        val onScrollListener = object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                when (newState) {
                    RecyclerView.SCROLL_STATE_IDLE -> {
                        val position =
                            (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                        gridIndicator.setCurrentPosition(ceil((position / 6).toDouble()).toInt())
                    }
                }
            }
        }
        binding.rvCategory.addOnScrollListener(onScrollListener)
    }

    private fun initAdapter() {
        categoryAdapter = HomeCategoryAdapter()
        binding.rvCategory.adapter = categoryAdapter
        categoryAdapter.categoryList.addAll(
            listOf(
                HomeCategoryData("UX/UI 아티클1", 28),
                HomeCategoryData("UX/UI 아티클2", 28),
                HomeCategoryData("UX/UI 아티클3", 28),
                HomeCategoryData("UX/UI 아티클4", 28),
                HomeCategoryData("UX/UI 아티클5", 28),
                HomeCategoryData("UX/UI 아티클6", 28),
                HomeCategoryData("UX/UI 아티클7", 28),
                HomeCategoryData("UX/UI 아티클8", 28),
                HomeCategoryData("UX/UI 아티클9", 28),
                HomeCategoryData("UX/UI 아티클10", 28),
                HomeCategoryData("UX/UI 아티클11", 28),
                HomeCategoryData("UX/UI 아티클12", 28),
                HomeCategoryData("UX/UI 아티클13", 28),
                HomeCategoryData("UX/UI 아티클14", 28),
                HomeCategoryData("UX/UI 아티클15", 28),
                HomeCategoryData("UX/UI 아티클16", 28),
                HomeCategoryData("UX/UI 아티클17", 28),

                )
        )
        categoryAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}