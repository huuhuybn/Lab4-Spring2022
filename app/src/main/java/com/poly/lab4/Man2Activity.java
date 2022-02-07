package com.poly.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Man2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man2);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("data");
        int boiChung = bundle.getInt("num");

        Toast.makeText(this,"" + boiChung,
                Toast.LENGTH_SHORT).show();
    }
}