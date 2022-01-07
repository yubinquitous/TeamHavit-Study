package com.example.havit.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.havit.databinding.FragmentMyPageBinding
import com.example.havit.util.CustomWebView

class MyPageFragment : Fragment() {

    private lateinit var notificationsViewModel: MyPageViewModel
    private var _binding: FragmentMyPageBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(MyPageViewModel::class.java)

        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.textHome.setOnClickListener {
            CustomWebView.setView(requireContext(),"https://github.com/boostcampwm-2021/android03-Contact/wiki/Git-%EC%82%AC%EC%9A%A9%EB%B2%95")

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}