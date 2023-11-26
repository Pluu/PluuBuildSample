package com.pluu.buildsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pluu.DynamicBuildConfiguration
import com.pluu.StaticBuildConfiguration
import com.pluu.anylibrary.AnySampleActivity
import com.pluu.buildsample.databinding.ActivityMainBinding
import com.pluu.feature.mylibrary.MyLibraryActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvStaticTextView.text = StaticBuildConfiguration.path

        binding.tvDynamicTextView.text = DynamicBuildConfiguration.path

        binding.btnMoveFeature.setOnClickListener {
            MyLibraryActivity.start(this)
        }
        binding.btnMoveFeature2.setOnClickListener {
            AnySampleActivity.start(this)
        }
    }
}