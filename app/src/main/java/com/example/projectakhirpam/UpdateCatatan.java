package com.example.projectakhirpam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateCatatan extends AppCompatActivity {
    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    EditText Judul, Isi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_catatan);
        database = new Database(this);
        Judul = findViewById(R.id.Judul);
        Isi = findViewById(R.id.Isi);
        btn_simpan = findViewById(R.id.btn_simpan);
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM catatan WHERE Judul = '"+
                getIntent().getStringExtra("Judul")+"'",null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            cursor.moveToPosition(0);
            Judul.setText(cursor.getString(0).toString());
            Isi.setText(cursor.getString(1).toString());
        }

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("update catatan set Judul= '" +
                        Judul.getText().toString()+"', Isi='" +
                        Isi.getText().toString()+"'where Judul='" +
                        getIntent().getStringExtra("Judul")+"'");
                Toast.makeText(UpdateCatatan.this,"Data berhasil diupdate",Toast.LENGTH_SHORT).show();
                Catatan.ct.RefreshList();
                finish();
            }
        });
    }
}