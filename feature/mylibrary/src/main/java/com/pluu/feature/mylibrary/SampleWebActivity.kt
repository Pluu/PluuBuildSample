package com.pluu.feature.mylibrary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pluu.feature.mylibrary.databinding.ActivitySampleWebBinding

class SampleWebActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySampleWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySampleWebBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.webView.webViewClient = CustomWebViewClient()
        binding.webView.settings.javaScriptEnabled = true

        val url = intent.getStringExtra("url").orEmpty()
        binding.webView.loadUrl(url)
    }

    companion object {
        fun start(context: Context, url: String) {
            context.startActivity(
                Intent(context, SampleWebActivity::class.java).apply {
                    putExtras(bundleOf("url" to url))
                }
            )
        }
    }
}

class CustomWebViewClient : WebViewClient() {
    override fun onReceivedError(
        view: WebView,
        request: WebResourceRequest,
        error: WebResourceError
    ) {
        super.onReceivedError(view, request, error)
        if (request.isForMainFrame) {
            view.loadUrl("file:///android_asset/error.html")
        }
    }
}