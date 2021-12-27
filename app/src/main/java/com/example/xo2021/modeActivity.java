package com.example.xo2021;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class modeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);
        Button b1 = findViewById(R.id.b1);
        Button b2 = findViewById(R.id.b2);
        a1=0;
        a2=0;
        b1.setOnClickListener(v -> modeActivity.this.ButtonClicked());
        b2.setOnClickListener(v -> modeActivity.this.ButtonClicked2());
    }
    public static int a1;
    public static int a2;

    private void ButtonClicked() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startloginActivity1();
        }, 0);

    }
    private void ButtonClicked2() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startloginActivity2();
        }, 0);

    }


    private void startloginActivity1() {
        Intent intent = new Intent(this, loginActivity1.class);
        startActivity(intent);
        a1=1;
    }
    private void startloginActivity2() {
        Intent intent = new Intent(this, loginActivity2.class);
        startActivity(intent);
        a2 =1;
    }
}
