package com.example.explicitintents;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText ET1 ;
    Button BTN1;
    Button BTN2;
    TextView TV1;
    final int ACTIVITY_3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ET1 = findViewById(R.id.ET1);
        BTN1 = findViewById(R.id.BTN1);
        BTN2 = findViewById(R.id.BTN2);
        TV1 = findViewById(R.id.TV1);

        BTN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ET1.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Enter all Fields!",Toast.LENGTH_SHORT).show();
                }
                else {
                    String name = ET1.getText().toString().trim();
                    // Accessing Activity2 from main Activity creating a new intent
                    Intent intent = new Intent(MainActivity.this,com.example.explicitintents.Activity2.class );
                    intent.putExtra("data",name);
                    startActivity(intent);

                }
            }
        });

        BTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(MainActivity.this,com.example.explicitintents.Activity3.class );
             startActivityForResult(intent,ACTIVITY_3);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ACTIVITY_3)
        {
             if(resultCode == RESULT_OK)
             {
                 TV1.setText(data.getStringExtra("data_name"));
             }
             if(resultCode == RESULT_CANCELED)
             {
                TV1.setText("No data Received! ");
             }
        }

    }
}