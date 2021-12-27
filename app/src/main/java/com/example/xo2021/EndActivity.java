package com.example.xo2021;

import static com.example.xo2021.PlayActivity.win;
import static com.example.xo2021.PlayActivity1.Player;
import static com.example.xo2021.PlayActivity1.computer;
import static com.example.xo2021.PlayActivity1.winner;
import static com.example.xo2021.PlayActivity2.winner;
import static com.example.xo2021.PlayActivity2.Player1;
import static com.example.xo2021.PlayActivity2.Player2;

import static com.example.xo2021.loginActivity2.players;
import static com.example.xo2021.modeActivity.a1;
import static com.example.xo2021.modeActivity.a2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EndActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        if(a2==0 && a1==1){
            textUpdatewin("It's "+PlayActivity1.winner());}
        else {
            textUpdatewin("It's "+PlayActivity2.winner());
        }
        textUpdateScore1();
        textUpdateScore2();

        Button b1 = findViewById(R.id.m);
        Button b2 = findViewById(R.id.Pa);
        b1.setOnClickListener(v -> EndActivity.this.ButtonClicked());
        b2.setOnClickListener(v -> EndActivity.this.ButtonClicked2());

    }
    static int[]score ;
    private void ButtonClicked() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startmainActivity();
        }, 0);

    }
    private void ButtonClicked2() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startPlayActivity();
        }, 0);

    }
    void textUpdatewin(String s) {
        TextView status = findViewById(R.id.textwin);
        status.setText(s);
    }
    void textUpdateScore1() {
        TextView status = findViewById(R.id.score1);
        status.setText(players[0]+"  "+score[0]);
    }
    void textUpdateScore2() {
        TextView status = findViewById(R.id.score2);
        status.setText(score[1]+"  "+players[1]);
    }


    private void startmainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void startPlayActivity() {
        Intent intent;
        if(a2==0 && a1==1)intent = new Intent(this, PlayActivity1.class);
        else intent = new Intent(this, PlayActivity2.class);
        startActivity(intent);
    }

}
