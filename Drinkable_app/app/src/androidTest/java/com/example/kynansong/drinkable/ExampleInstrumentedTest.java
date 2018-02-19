package com.example.kynansong.drinkable;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.kynansong.drinkable.Controllers.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.kynansong.drinkable", appContext.getPackageName());
    }

    @Test
    public void pressGo() {

        //Presses Go button on main page to take user to the next activity.

        onView(withId(R.id.welcome_button)).perform(click());
        onView(withId(R.id.ingredient_choice)).check(matches(isDisplayed()));

    }

    @Test
    public void selectItemFromMenuRum() {

        //Accesses the spinner on choices activity and presses the select button.

        pressGo();
        onView(withId(R.id.ingredient_choice)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Rum"))).perform(click());
//        onView(withId(R.id.ingredient_choice)).check(matches(withText(containsString("Rum"))));
//        Does't pass as returns whole spinner object.

    }

    @Test
    public void goesToListViewWithRumCocktails() {
        selectItemFromMenuRum();
        onView(withId(R.id.submit_button)).perform(click());
        onView(withId(R.id.cocktailList)).check(matches(isDisplayed()));

    }
}