package com.example.weliveinasimulation;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.weliveinasimulation.ActionType.NO_ACTION;

public class ActionList extends LinearLayout {

    ArrayList<Action> actionList;
    int selectedAction = -1;

    public ActionList(Context context) {
        super(context);
        new ActionList(context, MainActivity.Player.FISHERMAN);
    }

    public ActionList(Context context, MainActivity.Player player) {
        super(context);

        if (player == MainActivity.Player.FISHERMAN) {
            actionList = new ArrayList<>();
            actionList.add(new Action(context, ActionType.MAN_FIX));
            actionList.add(new Action(context, ActionType.MAN_BAIT));
            actionList.add(new Action(context, ActionType.MAN_FISHNET));
            actionList.add(new Action(context, ActionType.MAN_MOVE));
        } else if (player == MainActivity.Player.FISH) {
            actionList = new ArrayList<>();
            actionList.add(new Action(context, ActionType.FISH_ATTACK));
            actionList.add(new Action(context, ActionType.FISH_MOVE));
        }

        actionList.forEach(this::addView);
        setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        Log.e("hiiii", "hi");
    }
}
