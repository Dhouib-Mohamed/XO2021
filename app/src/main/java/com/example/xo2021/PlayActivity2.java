package com.example.xo2021;


import static com.example.xo2021.loginActivity2.players;
import static com.example.xo2021.EndActivity.score;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PlayActivity2 extends PlayActivity{
    static int Player1 ;
    static int Player2 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (players[0] =="")players[0]="Player1";
        if (players[1] =="")players[1]="Player2";
        Player1 = rand(0,1);
        Player2 = (Player1==0) ? 1 : 0;
        textUpdate(ActivePlayer);
    }


    void textUpdate(int s) {
        TextView status = findViewById(R.id.status);
        status.setText("It's Player" +(s+1)+ " 's Turn - Tap to play");
    }
    @Override
    public void playerTap(View view) {
        super.playerTap(view);
        if (win() != 2 || full()) {
            EndActivity();
        }
        ActivePlayer = (ActivePlayer == 0) ? 1 : 0;
        textUpdate(ActivePlayer);
    }
    protected static String winner() {
        if(win()==2) return("a Draw :(");
        if(win()==Player1) {
            score[0]++;
            return (players[0] + "'s Win :)");
        }
        if(win()==Player2) {
            score[1]++;
            return (players[1] + "'s Win :)");
        }
        return"";
    }
}
