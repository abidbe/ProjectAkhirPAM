package com.example.projectakhirpam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button btnnn;
    String nama;
    EditText ednm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnnn = findViewById(R.id.btn_nm);
        ednm = findViewById(R.id.namaid);

        btnnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = ednm.getText().toString();
                if(nama.isEmpty()){

                        Snackbar.make(view, "Silahkan isi nama anda...", Snackbar.LENGTH_LONG).show();

                }
                else{
                    Bundle b = new Bundle();
                    b.putString("a", nama.trim());

                    Intent i = new Intent(getApplicationContext(),Home.class);
                    i.putExtras(b);
                    startActivity(i);

                }
            }
        });
    }
}