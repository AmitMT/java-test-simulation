package com.example.weliveinasimulation;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.function.Consumer;

public class Board extends LinearLayout {
    int num;
    Tile[][] tiles;

    public Board(Context context, AttributeSet attributeSet) {
        this(context, 8);
    }

    public Board(Context context, int num) {
        super(context);
        this.num = num;
        int width = UsefulFunctions.getScreenWidth(context);

        tiles = new Tile[num][num];

        LinearLayout.LayoutParams boardParams = new LinearLayout.LayoutParams(width, width + 1 - 1);
        setLayoutParams(boardParams);
        setOrientation(VERTICAL);

        for (int i = 0; i < num; i++) {
            LinearLayout tempLayout = new LinearLayout(context);
            tempLayout.setOrientation(HORIZONTAL);
            tempLayout.setLayoutParams(new LinearLayout.LayoutParams(width, width / num));
            for (int j = 0; j < num; j++) {
                int finalI = i;
                int finalJ = j;
                tiles[i][j] = new Tile(context, (i + j) % 2 == 1, width / num);
                tiles[i][j].setOnClickListener((View view) -> {
                });
                tempLayout.addView(tiles[i][j]);
            }
            addView(tempLayout);
        }
    }


}
