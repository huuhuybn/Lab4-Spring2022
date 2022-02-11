package com.poly.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDatabase myDatabase = new MyDatabase(MainActivity.this);
        EditText id = findViewById(R.id.editTextNumber);
        EditText name = findViewById(R.id.editTextNumber2);
        EditText phone = findViewById(R.id.editTextTextPersonName);

        Button them = findViewById(R.id.button);
        Button sua = findViewById(R.id.button2);
        Button laydanhsach = findViewById(R.id.button3);
        Button xoa = findViewById(R.id.button4);
        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              int _id = Integer.parseInt(id.getText().toString());
              String _name = name.getText().toString();
              String _phone = phone.getText().toString();
              long kq = myDatabase.insertStudent(_id,_name,_phone);
              if (kq >0) {
                  Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_SHORT).show();
              }else {
                  Toast.makeText(MainActivity.this,"KHONG THANH CONG",Toast.LENGTH_SHORT).show();
              }
            }
        });
        sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int _id = Integer.parseInt(id.getText().toString());
                String _name = name.getText().toString();
                String _phone = phone.getText().toString();
                long kq = myDatabase.updateStudent(_id,_name,_phone);
                if (kq >0) {
                    Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"KHONG THANH CONG",Toast.LENGTH_SHORT).show();
                }
            }
        });
        laydanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Student> students = myDatabase.getAllStudents();
                // dua danh sanh len ListView

            }
        });
        xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int _id = Integer.parseInt(id.getText().toString());
                long kq = myDatabase.deleteStudent(_id);
                if (kq >0) {
                    Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"KHONG THANH CONG",Toast.LENGTH_SHORT).show();
                }
            }
        });




    }


}