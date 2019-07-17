package ru.elminn.weater_mvvm

import android.graphics.Bitmap
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.robolectric.annotation.Config
import ru.elminn.weater_mvvm.ui.DayForecastActivity
import android.widget.EditText
import androidx.test.espresso.matcher.ViewMatchers.*


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
        //TODO EditView actions don't work
       /* onView(withId(R.id.testEditView))
            .perform(
                click())//typeText("HELLO"))//, replaceText("HELLO"), closeSoftKeyboard())

        onView(withId(R.id.testEditView)).check(matches(withText("HELLO")))*/
    }
}