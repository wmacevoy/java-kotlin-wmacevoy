package com.capco.fragmentplusviewmodel.ui.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.capco.fragmentplusviewmodel.MainActivity
import com.capco.fragmentplusviewmodel.R
import org.junit.Assert.*
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith

// Started from...
// https://www.tutorialspoint.com/espresso_testing/espresso_testing_tutorial.pdf

@RunWith(AndroidJUnit4::class)
class MainFragmentTest {
    @Rule
    @JvmField
    val mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testMessage() {
        val viewInteraction = Espresso.onView(ViewMatchers.withText("Hello World!"))
        Espresso.onView(ViewMatchers.withId(R.id.message)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        viewInteraction.check(ViewAssertions.matches(ViewMatchers.withId(R.id.message)));
    }

}