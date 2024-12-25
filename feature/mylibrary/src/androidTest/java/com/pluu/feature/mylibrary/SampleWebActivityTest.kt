package com.pluu.feature

import android.content.Intent
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.web.assertion.WebViewAssertions.webMatches
import androidx.test.espresso.web.model.Atoms.getTitle
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pluu.feature.mylibrary.SampleWebActivity
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class SampleWebActivityTest {
    @get:Rule
    val rule = activityScenarioRule<SampleWebActivity>(
        intent = Intent(getApplicationContext(), SampleWebActivity::class.java).apply {
            putExtra("url", "file:///android_asset/sample.html")
        }
    )

    @Test
    fun t1() {
        onWebView()
            .withTimeout(30, TimeUnit.SECONDS)
            .check(webMatches(getTitle(), containsString("Pluu")))
    }
}