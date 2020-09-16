package com.berkantcanerkanat.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
     TextView baslik;
     TextView text;
     int count=0;
    Singleton singleton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        baslik = findViewById(R.id.baslik);
        text = findViewById(R.id.text);

        singleton = Singleton.getInstance();
        baslik.setText(singleton.getBaslik());
        text.setText(singleton.getText());

    }
    public void edit(View view){
       singleton.setSira(2);
       Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
       startActivity(intent);
    }

    public void delete(View view){
        int k = 0 ;
        for(int i = 0;i<MainActivity.kaydolanSayi;i++) {
            if(MainActivity.bastigimSira == i) continue;
            MainActivity.sharedPreferences.edit().putString("b"+k,MainActivity.basliklar[i]).apply();
            MainActivity.sharedPreferences.edit().putString("t"+k,MainActivity.textler[i]).apply();
            k++;
        }
        MainActivity.sharedPreferences.edit().putInt("sayi",--MainActivity.kaydolanSayi).apply();
        Toast.makeText(getApplicationContext(),"data deleted successfully",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(intent);
    }

}