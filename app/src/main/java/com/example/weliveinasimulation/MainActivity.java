package com.example.weliveinasimulation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public enum Player {
        FISHERMAN,
        FISH
    }

    Player turn = Player.FISHERMAN;

    int roundsLeft = 30;

    LinearLayout actionListContainer;
    ActionList actionList1;
    ActionList actionList2;
    int id1;
    int id2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionList1 = new ActionList(getApplicationContext(), Player.FISHERMAN);
        actionList2 = new ActionList(getApplicationContext(), Player.FISH);

        actionListContainer = findViewById(R.id.contain);
        id1 = LinearLayout.generateViewId();
        actionList1.setId(id1);
        id2 = LinearLayout.generateViewId();
        actionList2.setId(id2);
        actionListContainer.addView(actionList1);
        actionListContainer.addView(actionList2);
        ((ActionList) findViewById(id2)).setVisibility(View.GONE);

        findViewById(R.id.sunset).setOnClickListener((View view) -> {
            createTurnDialog();
        });

        Thread thread = new Thread(() -> {
            int counter = 0;
            while (true) {
                counter++;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        });

        thread.start();
    }

    void createTurnDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.turn_dialog);
        dialog.setTitle("Turn Ended");
        dialog.setCancelable(true);
        dialog.findViewById(R.id.ok).setOnClickListener((View view) -> {
            dialog.cancel();
            turn = turn == Player.FISHERMAN ? Player.FISH : Player.FISHERMAN;
            ((ImageView) findViewById(R.id.turn_image)).setImageResource(turn == Player.FISHERMAN ? R.drawable.fisherman : R.drawable.fish);
            if (turn == Player.FISHERMAN) {
                roundsLeft--;
                ((TextView) findViewById(R.id.rounds_left)).setText(String.valueOf(roundsLeft));

                ((ActionList) findViewById(id2)).setVisibility(View.GONE);
                ((ActionList) findViewById(id1)).setVisibility(View.VISIBLE);
            } else {
                ((ActionList) findViewById(id1)).setVisibility(View.GONE);
                ((ActionList) findViewById(id2)).setVisibility(View.VISIBLE);
            }
        });
        dialog.show();
    }
}