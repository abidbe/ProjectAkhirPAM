package com.example.projectakhirpam;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Catatan extends AppCompatActivity {
    String[] daftar;
    ListView listView;
    Menu menu;
    protected Cursor cursor;
    Database database;
    public static Catatan ct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catatan);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(Catatan.this,CreateCatatan.class);
                startActivity(pindah);
            }
        });
        ct = this;
        database = new Database(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM catatan",null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for(int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            daftar[i] = cursor.getString(0).toString();
        }
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1,daftar));
        listView.setSelected(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"Lihat catatan","Update catatan","Hapus catatan"};
                AlertDialog.Builder builder = new AlertDialog.Builder(Catatan.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item){
                        switch (item){
                            case 0:
                                Intent i = new Intent(getApplicationContext(),DetailCatatan.class);
                                i.putExtra("Judul",selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent in = new Intent(getApplicationContext(),UpdateCatatan.class);
                                in.putExtra("Judul",selection);
                                startActivity(in);
                                break;
                            case 2:
                                SQLiteDatabase db = database.getWritableDatabase();
                                db.execSQL("delete from catatan where Judul ='"+ selection +"'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter)listView.getAdapter()).notifyDataSetInvalidated();


    }
}



