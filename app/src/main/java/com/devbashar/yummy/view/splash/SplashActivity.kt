package com.devbashar.yummy.view.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devbashar.yummy.databinding.ActivitySplashBinding
import com.devbashar.yummy.view.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        CoroutineScope(Dispatchers.Default).launch {
            delay(3000)
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
        }

    }
}