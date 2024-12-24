package com.pluu.buildsample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.web.assertion.WebViewAssertions.webContent
import androidx.test.espresso.web.matcher.DomMatchers.hasElementWithId
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pluu.feature.mylibrary.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var rule = activityScenarioRule<MainActivity>()

    @Test
    fun t1() {
        onView(withId(R.id.btnMoveWeb))
            .perform(click())

        onWebView()
            .withTimeout(30, TimeUnit.SECONDS)
            .check(webContent(hasElementWithId("confirm")))
    }
}