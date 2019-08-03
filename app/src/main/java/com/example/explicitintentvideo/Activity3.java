package com.example.explicitintentvideo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    EditText et_surname;
    Button btn_submit,btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        et_surname = findViewById(R.id.et_surname);
        btn_submit = findViewById((R.id.btn_submit));
        btn_cancel = findViewById(R.id.btn_cancel);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_surname.getText().toString().isEmpty()) {
                    Toast.makeText(Activity3.this,"Put surname",Toast.LENGTH_SHORT).show();
                } else {
                    String surname = et_surname.getText().toString().trim();
                    Intent intent = new Intent();
                    intent.putExtra("surname",surname);
                    setResult(RESULT_OK,intent);
                    Activity3.this.finish();
                }
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                Activity3.this.finish();
            }
        });
    }
}
