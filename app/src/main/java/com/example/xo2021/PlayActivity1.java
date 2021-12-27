package com.example.xo2021;

import static com.example.xo2021.loginActivity2.players;
import static com.example.xo2021.EndActivity.score;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity1 extends PlayActivity{
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Player = ActivePlayer;
        computer = (Player==0) ? 1 : 0;
        if (players[0] == "")players[0] ="Player";
        players[1] = "Computer";
        if (rand(0,1) == 1) {
            ordset(ordAlea(),computer);
        }
        textUpdate("It's Your Turn - Tap to play");
    }
    static int Player;
    static int computer;
    protected static String winner() {
        if(win()==2) return("a Draw :(");
        if(win()==Player) {
            score[0]++;
            return ("Your Win :)");
        }
        if(win()==computer) {
            score[1]++;
            return ("Your Loss :) :)");
        }
        return "";

    }

    int ordAlea() {
        int x ,a;
        do {
            x = rand(0,8);
            a = status [x];
            if(a==2) {
                status[x] = computer;
            }
        } while(a!=2);

        return x;
    }

    int ordPlay() {
        int pos=-1;
        //        Cas de 2:computer
        for (int[] i : winCom) {
            if (combination(i, computer) == 2 && vide(i)!=-1) {
                pos =vide(i);
                status[pos] = computer;
                System.out.println(pos);
                return pos;
            }
        }
//        Cas de 2:player
        for (int[] i : winCom) {
            if (combination(i, Player) == 2 && vide(i)!=-1) {
                pos =vide(i);
                status[pos] = computer;
                System.out.println(pos);
                return pos;
            }

        }
//            Cas de 1:computer 1:player
        for (int[] i : winCom) {
            if ((combination(i, computer) == 1) && (combination (i,Player)==0)) {
                pos =vide(i);
                status[pos] = computer;
                System.out.println(pos);
                return pos;
            }
        }
        for (int[] i : winCom) {
            if ((combination(i, computer) == 0) && (combination (i,Player)==1)) {
                pos =vide(i);
                status[pos] = computer;
                System.out.println(pos);
                return pos;
            }
        }
        for (int[] i : winCom) {
            if ((combination(i, computer) == 0) && (combination (i,Player)==0)) {
                pos =vide(i);
                status[pos] = computer;
                System.out.println(pos);
                return pos;
            }
        }
        pos= ordAlea();
        return pos;

    }
    void textUpdate(String s) {
        TextView status = findViewById(R.id.status);
        status.setText(s);
    }
    @Override
    public void playerTap(View view) {

        super.playerTap(view);
        if (win() != 2 || full()) {
            EndActivity();
            return;}
        textUpdate("");
        ordset(ordPlay(),computer);
        if (win() != 2 || full()) {
            EndActivity();
            return;}
        textUpdate("It's Your Turn - Tap to play");
    }
    private void ordset(int pos,int computer) {
        ImageView view = null;
        switch(pos) {
            case 0:view = findViewById(R.id.imageView0);break;
            case 1:view = findViewById(R.id.imageView1);break;
            case 2:view = findViewById(R.id.imageView2);break;
            case 3:view = findViewById(R.id.imageView3);break;
            case 4:view = findViewById(R.id.imageView4);break;
            case 5:view = findViewById(R.id.imageView5);break;
            case 6:view = findViewById(R.id.imageView6);break;
            case 7:view = findViewById(R.id.imageView7);break;
            case 8:view = findViewById(R.id.imageView8);break;
        }
        if (computer == 1) {
            // set the image of x
            view.setImageResource(R.drawable.x);

        } else {
            // set the image of o
            view.setImageResource(R.drawable.o);
        }
    }


}
