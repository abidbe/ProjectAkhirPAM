package com.example.projectakhirpam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateCatatan extends AppCompatActivity {
    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    EditText Judul, Isi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_catatan);
        database = new Database(this);
        Judul = findViewById(R.id.Judul);
        Isi = findViewById(R.id.Isi);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("insert into catatan(Judul,Isi) values('" +
                        Judul.getText().toString() + "','" +
                        Isi.getText().toString() +"')");
                Toast.makeText(CreateCatatan.this,"Data tersimpan",Toast.LENGTH_SHORT).show();
                Catatan.ct.RefreshList();
                finish();
            }
        });
    }
}