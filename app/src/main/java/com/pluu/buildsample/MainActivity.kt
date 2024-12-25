package com.pluu.buildsample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pluu.ConstStaticBuildConfiguration
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
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.tvStaticTextView.text = StaticBuildConfiguration.path

        // Const로 정의한 경우는 모듈마다 동이하지 값이 동일하지 않음
        binding.tvStaticConstTextView.text = ConstStaticBuildConfiguration.path

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