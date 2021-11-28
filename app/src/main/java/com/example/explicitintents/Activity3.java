package com.example.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

     TextView TV2;
      EditText ET3;
      Button BTN3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        TV2 = findViewById(R.id.TV2);
        ET3 = findViewById(R.id.ET3);
        BTN3 = findViewById(R.id.BTN3);

        BTN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ET3.getText().toString().isEmpty())
                {
                    Toast.makeText(Activity3.this,"Enter Compulsory Fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                   String  Name = ET3.getText().toString();
                   Intent intent = new Intent();
                   intent.putExtra("data_name",Name);
                   setResult(RESULT_OK,intent);
                   Activity3.this.finish();
                }
            }
        });

    }
}