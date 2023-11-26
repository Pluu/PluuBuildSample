package com.pluu.feature.mylibrary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pluu.ConstStaticBuildConfiguration
import com.pluu.FlavorBuildConfiguration
import com.pluu.StaticBuildConfiguration
import com.pluu.feature.mylibrary.databinding.ActivityMyLibraryBinding

class MyLibraryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMyLibraryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyLibraryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvStaticTextView.text = StaticBuildConfiguration.path

        // Const로 정의한 경우는 모듈마다 동이하지 값이 동일하지 않음
        binding.tvStaticConstTextView.text = ConstStaticBuildConfiguration.path

        binding.tvFlavorTextView.text = FlavorBuildConfiguration().path()
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, MyLibraryActivity::class.java))
        }
    }
}