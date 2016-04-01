package com.apeace.markdownpreview;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PreviewMarkdownTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testPreviewButton() {
        onView(withId(R.id.preview_button))
                .perform(click());
        onView(withId(R.id.markdown_preview))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testMarkdownPreview() {
        String markdown = "This is **bold**";
        onView(withId(R.id.markdown_text))
                .perform(typeText(markdown), closeSoftKeyboard());
        onView(withId(R.id.preview_button))
                .perform(click());
        onView(withId(R.id.markdown_preview))
                .check(matches(isDisplayed()));
        /*
        // TODO http://developer.android.com/reference/android/support/test/espresso/web/assertion/WebViewAssertions.html
        onView(withId(R.id.web_view))
                .check(matches(...TODO...));
        */
    }

}