package com.example.explicitintentvideo;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText et_name;
    Button btn_act_2, btn_act_3;
    TextView tv_res;
    final int ACT3 = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.et_name);
        btn_act_2 = findViewById(R.id.btn_act_2);
        btn_act_3 = findViewById(R.id.btn_act_3);
        tv_res = findViewById(R.id.tv_res);

        btn_act_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_name.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Pleas write your name", Toast.LENGTH_SHORT).show();
                } else {
                    String name = et_name.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this,
                            com.example.explicitintentvideo.Activity2.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }

            }
        });

        btn_act_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, com.example.explicitintentvideo.Activity3.class);
                startActivityForResult(intent, ACT3);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACT3) {

            if (resultCode == RESULT_OK) {
                tv_res.setText(data.getStringExtra("surname"));

            } else if (resultCode == RESULT_CANCELED) {
                tv_res.setText(getString(R.string.ndr));
            } else {

            }

        } else {
            Toast.makeText(MainActivity.this, "what?!", Toast.LENGTH_SHORT).show();
        }


    }
}
