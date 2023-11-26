package com.pluu.anylibrary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pluu.anylibrary.databinding.ActivityAnySampleBinding

class AnySampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnySampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnySampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, AnySampleActivity::class.java))
        }
    }
}