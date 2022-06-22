package com.example.projectakhirpam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Hadits extends AppCompatActivity {
    Button bthd1,bthd2,bthd3,bthd4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadits);
        bthd1 = findViewById(R.id.btn_hd1);
        bthd2 = findViewById(R.id.btn_hd2);
        bthd3 = findViewById(R.id.btn_hd3);
        bthd4 = findViewById(R.id.btn_hd4);

        bthd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Hdt1.class));
            }
        });
        bthd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Hdt2.class));
            }
        });
        bthd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Hdt3.class));
            }
        });
        bthd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Hdt4.class));
            }
        });





    }
}