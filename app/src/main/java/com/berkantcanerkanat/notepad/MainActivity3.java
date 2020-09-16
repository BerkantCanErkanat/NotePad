package com.berkantcanerkanat.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    EditText baslik;
    EditText text;
    Singleton singleton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        baslik = findViewById(R.id.baslik);
        text = findViewById(R.id.textin);
        singleton = Singleton.getInstance();

        if(singleton.getSira() != 1){
            text.setText(singleton.getText());
            baslik.setText(singleton.getBaslik());
        }

    }

    public void kaydet(View view){
       if(baslik.getText().toString().equals("") || text.getText().toString().equals("")){
           Toast.makeText(getApplicationContext(),"Baslik veya Text bos birakilamaz",Toast.LENGTH_LONG).show();
           return;
       }
       if(singleton.getSira() == 1){//yeni bir not kaydettik digerlerini de kaydettik ama

           MainActivity.sharedPreferences.edit().putString("b"+MainActivity.kaydolanSayi,baslik.getText().toString()).apply();
           MainActivity.sharedPreferences.edit().putString("t"+MainActivity.kaydolanSayi,text.getText().toString()).apply();
           MainActivity.sharedPreferences.edit().putInt("sayi",++MainActivity.kaydolanSayi).apply();
       }else{

           MainActivity.sharedPreferences.edit().putString("b"+MainActivity.bastigimSira,baslik.getText().toString()).apply();
           MainActivity.sharedPreferences.edit().putString("t"+MainActivity.bastigimSira,text.getText().toString()).apply();
       }
       Toast.makeText(getApplicationContext(),"saved successfully",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity3.this,MainActivity.class);
        startActivity(intent);
    }
}