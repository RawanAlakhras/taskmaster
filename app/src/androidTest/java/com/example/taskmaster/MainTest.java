package com.example.taskmaster;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainTest {
    @Rule
    public ActivityScenarioRule<MainActivity> mainRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);
    @Test
    public void testAddTask() {
        onView(withId(R.id.button)).check(matches(isDisplayed()));


//        onView(withText("Hello Steve!")).check(matches(isDisplayed()));
    }
    @Test
    public void testSettings() {
        onView(withId(R.id.settings)).check(matches(isDisplayed()));
//        onView(withId(R.id.button)).perform(click());
//        onView(withId(R.id.title)).perform(typeText("test") , closeSoftKeyboard());
//        onView(withId(R.id.body)).perform(typeText("body") , closeSoftKeyboard());
//        onView(withId(R.id.button3)).perform(click());
//        //onView(withId(R.id.ListRecyclerView)).perform(actionOnItemAtPosition(0 ,click()));
//        onView(withText("hello test")).check(matches(isDisplayed()));

    }
    @Test
    public void testAllTask() {
        onView(withId(R.id.button2)).check(matches(isDisplayed()));


//        onView(withText("Hello Steve!")).check(matches(isDisplayed()));
    }
    @Test
    public void testSettingsName() {
        onView(withId(R.id.settings)).perform(click());
        onView(withId(R.id.name)).perform(typeText("test") , closeSoftKeyboard());
        onView(withId(R.id.button4)).perform(click());
        Espresso.pressBack();
        onView(withId(R.id.header)).check(matches(withText("test's Tasks ")));

    }
    @Test
    public void testNewTask() {
//        onView(withId(R.id.settings)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.title)).perform(typeText("test") , closeSoftKeyboard());
        onView(withId(R.id.body)).perform(typeText("body") , closeSoftKeyboard());
        onView(withId(R.id.button3)).perform(click());
        Espresso.pressBack();
        onView(withId(R.id.ListRecyclerView)).perform(actionOnItemAtPosition(0 ,click()));
        onView(withId(R.id.title1)).check(matches(withText("test")));
//        onView(withText("hello test")).check(matches(isDisplayed()));

    }
}
