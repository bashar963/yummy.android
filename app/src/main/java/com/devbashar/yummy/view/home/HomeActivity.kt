package com.devbashar.yummy.view.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devbashar.yummy.databinding.HomeActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: HomeActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}