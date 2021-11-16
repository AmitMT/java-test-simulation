package com.example.weliveinasimulation;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class UsefulFunctions {
    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int dpToPx(Context context, int dps) {
        // Get the screen's density scale
        final float scale = context.getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (dps * scale + 0.5f);
    }
}
