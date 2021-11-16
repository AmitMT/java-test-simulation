package com.example.weliveinasimulation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.function.Consumer;

public class Tile extends androidx.appcompat.widget.AppCompatImageView {
    boolean hasRipple;

    public Tile(@NonNull Context context) {
        this(context, false, UsefulFunctions.getScreenWidth(context) / 8);
    }

    public Tile(@NonNull Context context, AttributeSet attributeSet) {
        this(context, false, UsefulFunctions.getScreenWidth(context) / 8);
    }

    public Tile(@NonNull Context context, boolean isDark, int width) {
        super(context);

        setBackgroundResource(isDark ? R.drawable.sea_tile2 : R.drawable.sea_tile);
        setLayoutParams(new ViewGroup.LayoutParams(width, width + 1 - 1));
    }

    public void setHasRipple(boolean hasRipple) {
        this.hasRipple = hasRipple;
        setImageResource(hasRipple ? R.drawable.ripple : 0);
    }
}
