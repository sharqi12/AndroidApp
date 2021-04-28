package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button barometerbtn;
    Button webbtn;
    Button camerabtn;
    Button filebtn;
    Button videobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        barometerbtn = (Button) findViewById(R.id.btn5);
        webbtn = (Button) findViewById(R.id.btn4);
        camerabtn = (Button) findViewById(R.id.btn3);
        filebtn = (Button) findViewById(R.id.btn2);
        videobtn = (Button) findViewById(R.id.btn1);

        //PRZYCISK BAROMETR
        barometerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BaromterActivity.class);
                startActivity(intent);
            }
        });

        //PRZYCISK KOMUNIKACJA SIECIOWA
        webbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WebActivity.class);
                startActivity(intent);
            }
        });

        //PRZYCISK KAMERA
        camerabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
                startActivity(intent);
            }
        });

        //PRZYCISK PLIKI
        filebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FileOperationsActivity.class);
                startActivity(intent);
            }
        });

        //PRZYCISK VIDEO
        videobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                startActivity(intent);
            }
        });

    }
}
