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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            lifecycleOwner = this@MainActivity
            activity = this@MainActivity

            btnChange.setOnClickListener {
                if (liveText.value == "Hello DataBinding!")
                    liveText.value = "Hello LiveData!"
                else
                    liveText.value = "Hello DataBinding!"
            }
        }
        liveText.value = "Hello DataBinding!"
    }
}