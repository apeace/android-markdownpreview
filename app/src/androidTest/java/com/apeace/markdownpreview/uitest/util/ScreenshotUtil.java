package com.apeace.markdownpreview.uitest.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class ScreenshotUtil {

    // device farm automatically looks in this dir
    // http://docs.aws.amazon.com/devicefarm/latest/developerguide/test-types-android-instrumentation.html#test-types-android-instrumentation-screenshots
    public static final String SCREENSHOT_DIR = "/test-screenshots";

    public static final String LOG_TAG = ScreenshotUtil.class.getSimpleName();

    public static void takeScreenshot(String name, Activity activity) {
        takeScreenshot(name, activity.getWindow().getDecorView().getRootView());
    }

    public static void takeScreenshot(String name, View view) {
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            Log.e(LOG_TAG, "Media is not mounted");
            return;
        }

        String storagePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String screenshotPath = storagePath + SCREENSHOT_DIR;

        File screenshotDir = new File(screenshotPath + "/");
        if (!screenshotDir.isDirectory()) {
            Boolean dirCreated = screenshotDir.mkdirs();
            if (!dirCreated) {
                Log.e(LOG_TAG, "Could not create directory " + screenshotPath);
                return;
            }
        }

        String filename = screenshotDir + "/" + name + ".png";

        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);

        OutputStream out = null;
        File imageFile = new File(filename);

        try {
            out = new FileOutputStream(imageFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
        } catch (FileNotFoundException e) {
            Log.e(LOG_TAG, "FileNotFoundException", e);
        } catch (IOException e) {
            Log.e(LOG_TAG, "IOException", e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                // do nothing
            }
        }
    }

}
