package com.berkantcanerkanat.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


//textleri buyut delete calısmıyor edit falan calısıyor
public class MainActivity extends AppCompatActivity {
     static String [] basliklar;
     static String [] textler;
     static int kaydolanSayi=0;
     static SharedPreferences sharedPreferences;
     static int bastigimSira;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        sharedPreferences = getSharedPreferences("com.berkantcanerkanat.notepad",MODE_PRIVATE);
        kaydolanSayi = sharedPreferences.getInt("sayi",0);
        System.out.println(kaydolanSayi);
        basliklar = new String[kaydolanSayi];
        textler = new String[kaydolanSayi];
        for(int i = 0 ;i<kaydolanSayi;i++){
            basliklar[i] = sharedPreferences.getString("b"+i,null);
            textler[i] = sharedPreferences.getString("t"+i,null);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,basliklar);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Singleton singleton = Singleton.getInstance();
                singleton.setBaslik(basliklar[i]);
                singleton.setText(textler[i]);
                bastigimSira=i;
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });



    }
    public void yeniBirNot(View view){

        Singleton singleton = Singleton.getInstance();
        singleton.setSira(1);
        Intent intent = new Intent(MainActivity.this,MainActivity3.class);
        startActivity(intent);
    }




}