package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //按钮点击
        Button denglu=(Button)findViewById(R.id.button1);
        denglu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,EnterActivity.class);
                startActivity(intent);
            }
        });
        Button xinxi=(Button)findViewById(R.id.button2);
        xinxi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
    }
}
