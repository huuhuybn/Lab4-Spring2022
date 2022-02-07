package com.poly.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText sothu1 = findViewById(R.id.editTextNumber);
        EditText sothu2 = findViewById(R.id.editTextNumber2);
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // su kien tinh toán xảy ra ở đây
                String num1 = sothu1.getText().toString();
                String num2 = sothu2.getText().toString();

                // tìm bội chung nhỏ nhất
                int so1 = Integer.parseInt(num1);
                int so2 = Integer.parseInt(num2);

                int boiChung = 1;

                while (true){
                    if (boiChung % so1 == 0 && boiChung % so2 == 0){
                        break;
                    }
                    boiChung++;
                }
                // chuyển màn hình .
                Intent intent = new Intent(MainActivity.this,
                        Man2Activity.class);
                Bundle bundle = new Bundle();
                // bỏ boiChung vào bundle
                bundle.putInt("num",boiChung);

                // bỏ bundle vào intent chuyển sang màn hình
                intent.putExtra("data",bundle);

                startActivity(intent);

            }
        });

        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "tel:0913360468" ;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(uri));
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String link = "https://www.google.com/maps/place/Hanoi+University/@21.0012405,105.7938072,14z/data=!4m5!3m4!1s0x3135adb29ed54487:0xbe22035eae87b5d7!8m2!3d20.9887865!4d105.7956311";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(link));
                startActivity(intent);
            }
        });

        MyDatabase myDatabase =
                new MyDatabase(MainActivity.this);
        myDatabase.themSinhVien();
        long kq = myDatabase.insertStudent(1,"Huy","09133604687");
        myDatabase.insertStudent(2,"Huy","09133604687");
        myDatabase.insertStudent(3,"Huy","09133604687");

        if (kq > 0){
            // thong bao la thanh cong
        }else {
            // thong báo ko thành công
        }


    }


}