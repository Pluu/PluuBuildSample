package com.pluu.buildsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pluu.FlavorBuildConfiguration
import com.pluu.StaticBuildConfiguration
import com.pluu.anylibrary.AnySampleActivity
import com.pluu.buildsample.databinding.ActivityMainBinding
import com.pluu.feature.mylibrary.MyLibraryActivity
import com.pluu.feature.mylibrary.SampleWebActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvStaticTextView.text = StaticBuildConfiguration.path

        binding.tvFlavorTextView.text = FlavorBuildConfiguration().path()

        binding.btnMoveFeature.setOnClickListener {
            MyLibraryActivity.start(this)
        }
        binding.btnMoveFeature2.setOnClickListener {
            AnySampleActivity.start(this)
        }
        binding.btnMoveWeb.setOnClickListener {
            SampleWebActivity.start(this, "https://github.com/Pluu")
        }
    }
}