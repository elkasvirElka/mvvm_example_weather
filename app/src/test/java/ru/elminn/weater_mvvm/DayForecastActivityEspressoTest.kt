package ru.elminn.weater_mvvm

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.robolectric.annotation.Config
import androidx.test.espresso.matcher.ViewMatchers.*
import ru.elminn.weater_mvvm.ui.dayforecast.DayForecastActivity


@RunWith(
    AndroidJUnit4::class)
@Config(manifest= Config.NONE)
class DayForecastActivityEspressoTest{

    @get:Rule
     val mActivityRule = ActivityTestRule(DayForecastActivity::class.java)

    @Test
    fun ensureTextChangesWork() {

        onView(withId(R.id.btnLoadWithRxJava))
            .perform(click())
        onView(withId(R.id.inputString))
            .perform(click())

        onView(withId(R.id.testEditView)).check(matches(withText("Lalala")))
        onView(withId(R.id.testEditView)).check(matches(isDisplayed()))
        var array = ArrayList<Int>()
        var sum : Long = 0
        for(i in array)
            sum += i

        //TODO EditView actions don't work
       /* onView(withId(R.id.testEditView))
            .perform(
                click())//typeText("HELLO"))//, replaceText("HELLO"), closeSoftKeyboard())

        onView(withId(R.id.testEditView)).check(matches(withText("HELLO")))*/
    }
}