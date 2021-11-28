package com.example.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Activity2 extends AppCompatActivity {

      TextView TV3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TV3 = findViewById(R.id.TV3);
        String name = getIntent().getStringExtra("data");
        TV3.setText(name+ "Welcome To Activity 2 ");

    }
}