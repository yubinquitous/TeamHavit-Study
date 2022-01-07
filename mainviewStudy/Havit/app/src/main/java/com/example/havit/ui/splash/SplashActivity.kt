package com.example.havit.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.havit.MainActivity
import com.example.havit.R
import com.example.havit.databinding.ActivitySplashBinding
import com.example.havit.ui.base.BaseBindingActivity
import com.example.havit.ui.kakao.SignInActivity

class SplashActivity : BaseBindingActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startFilterActivity()
    }

    private fun startFilterActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }, 1000)
    }
}