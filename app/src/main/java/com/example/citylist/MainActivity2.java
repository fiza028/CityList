package com.example.citylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        String c=i.getStringExtra("cityname");

        TextView tv1;
        Button btn;

        tv1=findViewById(R.id.textView2);
        tv1.setText(c);
        btn=findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
                finish();
            }
        });


    }
}