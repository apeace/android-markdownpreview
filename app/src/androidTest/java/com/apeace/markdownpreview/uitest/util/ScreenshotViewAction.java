package com.apeace.markdownpreview.uitest.util;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.view.View;

import org.hamcrest.Matcher;

public class ScreenshotViewAction implements ViewAction {

    public String name;
    public long delay;

    public ScreenshotViewAction(String screenshotName, long delayMilli) {
        name = screenshotName;
        delay = delayMilli;
    }

    public ScreenshotViewAction(String screenshotName) {
        this(screenshotName, 0);
    }

    public static ScreenshotViewAction screenshot(String name) {
        return new ScreenshotViewAction(name);
    }

    public static ScreenshotViewAction screenshot(String name, long delayMilli) {
        return new ScreenshotViewAction(name, delayMilli);
    }

    @Override
    public Matcher<View> getConstraints() {
        return ViewMatchers.isDisplayed();
    }

    @Override
    public String getDescription() {
        return "Taking a screenshot";
    }

    @Override
    public void perform(UiController uiController, View view) {
        uiController.loopMainThreadUntilIdle();
        if (delay > 0) {
            uiController.loopMainThreadForAtLeast(delay);
        }
        ScreenshotUtil.takeScreenshot(name, view.getRootView());
    }
}
