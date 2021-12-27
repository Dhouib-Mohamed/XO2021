package com.example.xo2021;
import static com.example.xo2021.loginActivity2.players;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class loginActivity1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        players = new String[]{"", ""};
        Button b = findViewById(R.id.start1);
        b.setOnClickListener(v -> loginActivity1.this.ButtonClicked());
    }
    private void ButtonClicked() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startplayActivity();
            finish();
        }, 0);

    }
    private void startplayActivity() {
        Intent intent = new Intent(this, PlayActivity1.class);

        startActivity(intent);


    }
}
