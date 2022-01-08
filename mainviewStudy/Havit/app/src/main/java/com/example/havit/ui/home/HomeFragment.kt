package com.example.havit.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.havit.R
import com.example.havit.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    val builder = CustomTabsIntent.Builder()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        initSearchScroll()
        initHomeCategoryFragment()

        return binding.root
    }

    private fun initHomeCategoryFragment() {
        val fragment1 = HomeCategoryFragment()
//        val fragment2 = HomeCateforyEmptyFragment()

        childFragmentManager.beginTransaction()
            .add(R.id.fcv_category, fragment1)
            .commit()
    }

    private fun initSearchScroll() {
        binding.nsvMain.run {
            header = binding.tvSearch
            stickListener = { _ ->
                Log.d("LOGGER_TAG", "stickListener")
            }
            freeListener = { _ ->
                Log.d("LOGGER_TAG", "freeListener")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}