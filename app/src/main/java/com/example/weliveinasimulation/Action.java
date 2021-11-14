package com.example.weliveinasimulation;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static com.example.weliveinasimulation.ActionType.*;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;


public class Action extends AppCompatImageView {
    int maxDistance;
    int affectSize;
    boolean selected;
    int amount;

    public Action(@NonNull Context context) {
        super(context);

        new Action(context, MAN_FIX);
    }

    public Action(@NonNull Context context, ActionType type) {
        super(context);

        this.setLayoutParams(new ViewGroup.LayoutParams(
                (int) convertDpToPixel(70, context),
                (int) convertDpToPixel(70, context)
        ));
        this.setBackgroundResource(R.drawable.square);

        switch (type) {
            case NO_ACTION:
                amount = -1;
                break;

            case MAN_FIX:
                amount = -1;
                this.setImageResource(R.drawable.repair);
                break;

            case MAN_BAIT:
                amount = -1;
                maxDistance = 1;
                affectSize = 1;
                this.setImageResource(R.drawable.bait);
                break;

            case MAN_FISHNET:
                amount = -1;
                maxDistance = 1;
                affectSize = 2;
                this.setImageResource(R.drawable.net);
                break;

            case MAN_FISHING_ROD:
                amount = -1;
                maxDistance = 1;
                affectSize = 1;
                this.setImageResource(R.drawable.fishing_rod);
                break;

            case MAN_MOVE:
                amount = -1;
                maxDistance = 2;
                this.setImageResource(R.drawable.paddles);
                break;

            case FISH_ATTACK:
                maxDistance = 1;
                affectSize = 1;
                this.setImageResource(R.drawable.attak);
                break;

            case FISH_MOVE:
                amount = -1;
                maxDistance = 1;
                this.setImageResource(R.drawable.swim);
                break;
        }
    }

    public void select() {
        selected = true;
        this.setBackgroundResource(R.drawable.green_square);
    }

    public void deselect() {
        selected = false;
        this.setBackgroundResource(R.drawable.square);
    }

    public static float convertDpToPixel(float dp, Context context) {
        return dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
