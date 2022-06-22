package com.example.projectakhirpam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Home extends AppCompatActivity {
    TextView username;
    Button bthds, btcttn, btinf, btex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        username = findViewById(R.id.tvnama);
        bthds = findViewById(R.id.btn_hds);
        btcttn = findViewById(R.id.btn_cttn);
        btinf = findViewById(R.id.btn_inf);
        btex = findViewById(R.id.btn_ex);


        Bundle bundle = getIntent().getExtras();

        String user = bundle.getString("a");
        username.setText(user);

        bthds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Hadits.class);
                startActivity(i);
            }
        });
        btcttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Catatan.class);
                startActivity(i);
            }
        });
        btinf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Informasi.class);
                startActivity(i);
            }
        });
        btex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });


    }
    public void onBackPressed(){
        showAlertDialog();
    }
    private void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setMessage("Apakah anda keluar?")
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}