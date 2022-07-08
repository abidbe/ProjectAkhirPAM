package com.example.projectakhirpam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetailCatatan extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    TextView Judul, Isi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_catatan);
        database = new Database(this);
        Judul = findViewById(R.id.Judul);
        Isi = findViewById(R.id.Isi);
        btn_simpan = findViewById(R.id.btn_simpan);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM catatan WHERE Judul = '" +
                getIntent().getStringExtra("Judul")+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            Judul.setText(cursor.getString(0).toString());
            Isi.setText(cursor.getString(1).toString());
        }
    }
}