package org.sopt.havit_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.sopt.havit_study.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    var text = "TEST"
    val liveText = MutableLiveData<String>()
    val liveVisible = MutableLiveData<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity  // binding에 LifeCycleOwner를 지정해줘야 LiveData가 실시간으로 변함!
            activity = this@MainActivity        // xml 파일에 선언한 activity

            btnChange.setOnClickListener {
                liveVisible.value = liveVisible.value != true
            }
        }
        liveText.value = "Hello DataBinding!"
        liveVisible.value = true
    }
}