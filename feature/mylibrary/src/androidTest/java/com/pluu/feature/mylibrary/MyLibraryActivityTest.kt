package com.pluu.feature.mylibrary

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.web.assertion.WebViewAssertions.webMatches
import androidx.test.espresso.web.model.Atoms.getTitle
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class MyLibraryActivityTest {
    @get:Rule
    val rule = activityScenarioRule<MyLibraryActivity>()

    @Test
    fun t1() {
        onView(withId(R.id.btnMoveWeb))
            .perform(click())

        onWebView()
            .withTimeout(30, TimeUnit.SECONDS)
            .check(webMatches(getTitle(), containsString("Pluu")))
    }
}