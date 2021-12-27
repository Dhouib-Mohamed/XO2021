package com.example.xo2021;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class loginActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        players= new String[]{"", ""};
        Button b = findViewById(R.id.start2);
        b.setOnClickListener(v -> loginActivity2.this.ButtonClicked());
    }
    static String[] players;
    private void ButtonClicked() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startplayActivity();
            finish();
        }, 0);

    }


    private void startplayActivity() {
        Intent intent = new Intent(this, PlayActivity2.class);
        startActivity(intent);
    }
}
