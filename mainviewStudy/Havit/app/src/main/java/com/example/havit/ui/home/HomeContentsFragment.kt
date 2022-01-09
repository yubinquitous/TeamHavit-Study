package com.example.havit.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.havit.R

class HomeContentsFragment : Fragment() {

    companion object {
        fun newInstance() = HomeContentsFragment()
    }

    private lateinit var viewModel: HomeContentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_contents_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeContentsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}