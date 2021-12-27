package com.example.xo2021;

import static com.example.xo2021.EndActivity.score;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score = new int[]{0, 0};
        Button b = findViewById(R.id.b);
        b.setOnClickListener(v -> MainActivity.this.ButtonClicked());


    }
    private void ButtonClicked() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startmodeActivity();
            finish();
        }, 0);

    }


    private void startmodeActivity() {
        Intent intent = new Intent(this, modeActivity.class);
        startActivity(intent);
    }
}