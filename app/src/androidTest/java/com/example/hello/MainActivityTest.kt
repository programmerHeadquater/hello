package com.example.hello

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.action.ViewActions.click
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private var scenario: ActivityScenario<MainActivity>? = null

    @Before
    fun setUp() {
        scenario = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario?.close()
    }

    @Test
    fun showFirstQuestionOnLaunch() {
        onView(withId(R.id.question_text_view))
            .check(matches(withText(R.string.question_australia)))
    }
    @Test
    fun showsNextQuestionAfterNextPress(){
        onView(withId(R.id.next_button)).perform(click())
        onView(withId(R.id.question_text_view))
            .check(matches(withText(R.string.question_ocean)))
    }
    @Test
    fun handlesActivityRecreation(){
        onView(withId(R.id.next_button)).perform(click())
        scenario?.recreate()
        onView(withId(R.id.question_text_view))
            .check(matches(withText(R.string.question_ocean)))
    }
}
