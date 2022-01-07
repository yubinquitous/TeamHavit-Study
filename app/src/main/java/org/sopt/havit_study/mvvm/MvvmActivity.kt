package org.sopt.havit_study.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import org.sopt.havit_study.R
import org.sopt.havit_study.databinding.ActivityMvvmBinding

class MvvmActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMvvmBinding
    private val model: MvvmViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm)

        mBinding.lifecycleOwner = this
        mBinding.viewModel = model
    }
}