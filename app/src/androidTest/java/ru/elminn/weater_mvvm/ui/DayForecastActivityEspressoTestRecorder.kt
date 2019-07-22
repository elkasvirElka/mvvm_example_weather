package ru.elminn.weater_mvvm.ui


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.elminn.weater_mvvm.R
import ru.elminn.weater_mvvm.ui.dayforecast.DayForecastActivity

@LargeTest
@RunWith(AndroidJUnit4::class)
class DayForecastActivityEspressoTestRecorder {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(DayForecastActivity::class.java)

    @Test
    fun dayForecastActivityEspressoTestRecorder() {
        val appCompatEditText = Espresso.onView(
            allOf(
                withId(R.id.testEditView), withText("weater_mvvm"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(click())

        val appCompatEditText2 = Espresso.onView(
            allOf(
                withId(R.id.testEditView), withText("weater_mvvm"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("weater_"))

        val appCompatEditText3 = Espresso.onView(
            allOf(
                withId(R.id.testEditView), withText("weater_"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(closeSoftKeyboard())

        val editText = Espresso.onView(
            allOf(
                withId(R.id.testEditView), withText("weater_"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        editText.check(matches(withText("weater_")))

        val appCompatButton = Espresso.onView(
            allOf(
                withId(R.id.btnLoadWithRxJava), withText("Refresh"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        val appCompatButton2 = Espresso.onView(
            allOf(
                withId(R.id.inputString), withText("Изменить текст"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        appCompatButton2.perform(click())

        val editText2 = Espresso.onView(
            allOf(
                withId(R.id.testEditView), withText("Lalala"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        editText2.check(matches(withText("Lalala")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
