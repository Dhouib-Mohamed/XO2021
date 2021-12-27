package com.example.xo2021;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayActivity extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        status = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
        List<int[]> inlist= Arrays.asList(winCom);
        Collections.shuffle(inlist);
        inlist.toArray(winCom);
        for(int[]i:winCom) {
            inlist= Arrays.asList(i);
            Collections.shuffle(inlist);
            inlist.toArray(new int[][]{i});
        }
    }

    protected int ActivePlayer= rand(0,1) ;
    protected static int []status ={2, 2, 2, 2, 2, 2, 2, 2, 2};
    protected static int [][] winCom ={{0, 4, 8}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 1, 2}, {2, 4, 6}};
    protected int rand(int min,int max) {
        return min+(int) (Math.random()*(max-min+1));
    }
    protected static int combination(int[] i, int x) {
        int y = 0;
        for (int k : i) {
            if (status[k] == x) {
                y++;
            }
        }
        return y;
    }
    protected static String winner() {
        return "";
    }
    protected static int win() {
        for(int j = 0;j<2;j++) {
            for (int[] i : winCom) {
                if (combination(i, j) == 3) {
                    return j;
                }
            }
        }
        return 2;

        }
    protected boolean full() {
        for (int i:status) {
            if(i==2){
                return false;
            }
        }
        return true;
    }

    protected int vide(int [] j) {
        for(int i:j) {
            if(status[i]==2) {
                return(i);
            }
        }
        return(-1);
    }

    protected void perSet(int player, int tappedImage, ImageView img) {

            status[tappedImage] = player;
            if (player == 1) {
                // set the image of x
                img.setImageResource(R.drawable.x);

            } else {
                // set the image of o
                img.setImageResource(R.drawable.o);
            }
    }
    protected void EndActivity() {
        Intent intent = new Intent(this, EndActivity.class);
        startActivity(intent);
    }

    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(status[tappedImage]==2) {
            perSet(ActivePlayer, tappedImage, img);
        }

    }
}

