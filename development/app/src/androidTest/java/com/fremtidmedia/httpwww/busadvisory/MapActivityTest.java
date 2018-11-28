package com.fremtidmedia.httpwww.busadvisory;

import org.junit.Test;

import static org.junit.Assert.*;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.rule.ActivityTestRule;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MapActivityTest {

    @Rule
    public ActivityTestRule<MapActivity> mActivityRule =
            new ActivityTestRule<>(MapActivity.class);


    @Test
    public void listShowsStuff() {
        onView(withId(R.id.BusList)).perform(click()).check(matches(withText("97")));
    }
    @Test
    public void listExpands() {
        onView(withId(R.id.BusList)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("97 south"))).perform(click());
        onView(withId(R.id.BusList))
                .check(matches(withText(containsString("97 south"))));

    }
    @Test
    public void mapExists() {
        onView(withId(R.id.mapfragment)).noActivity();
    }
    @Test
    public void mapTracks() {
        onView(withId(R.id.BusList)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("97 south"))).perform(click());
        double busLocationv = 0;
        double buslocationv1 = 0;
        double buslocationv2 = 0;
        assertEquals(busLocationv, 49.196261, 0);
        assertEquals(buslocationv1, -123.004773, 0);
        assertEquals(buslocationv2, 0.0, 0);

    }




}