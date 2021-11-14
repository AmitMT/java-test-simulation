package com.example.weliveinasimulation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public enum Player {
        FISHERMAN,
        FISH
    }

    Player turn = Player.FISHERMAN;

    int roundsLeft = 30;

    ActionList actionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionList = new ActionList(getApplicationContext(), turn);

        findViewById(R.id.sunset).setOnClickListener((View view) -> {
            turn = turn == Player.FISHERMAN ? Player.FISH : Player.FISHERMAN;
            ((ImageView) findViewById(R.id.turn_image)).setImageResource(turn == Player.FISHERMAN ? R.drawable.fisherman : R.drawable.fish);
            if (turn == Player.FISHERMAN) {
                roundsLeft--;
                ((TextView) findViewById(R.id.rounds_left)).setText(String.valueOf(roundsLeft));
            }
            createTurnDialog();
        });
    }

    void createTurnDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.turn_dialog);
        dialog.setTitle("Turn Ended");
        dialog.setCancelable(true);
        dialog.findViewById(R.id.ok).setOnClickListener((View view) -> {
            dialog.cancel();
        });
        dialog.show();
    }
}