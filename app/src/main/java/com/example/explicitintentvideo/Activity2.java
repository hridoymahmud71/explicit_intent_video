package com.example.explicitintentvideo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tv_welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tv_welcome = findViewById(R.id.tv_welcome);
        String name = getIntent().getStringExtra("name");
        tv_welcome.setText(name + ", " + getString(R.string.wa2));
    }
}
