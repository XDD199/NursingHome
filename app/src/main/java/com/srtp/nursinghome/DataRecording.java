package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataRecording extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_recording);

        Button toHome=(Button)findViewById(R.id.data_back);
        toHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DataRecording.this,BioMeasuren.class);
                startActivity(intent);
            }
        });

        //测量按钮监听事件
        Button xueya=(Button)findViewById(R.id.bt_xueya);
        xueya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setFocusable(true);
                v.requestFocus();
                v.requestFocusFromTouch();
            }
        });

        Button xueyang=(Button)findViewById(R.id.bt_xueyang);
        xueyang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setFocusable(true);
                v.requestFocus();
                v.requestFocusFromTouch();
            }
        });

        Button xuetang=(Button)findViewById(R.id.bt_xuetang);
        xuetang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setFocusable(true);
                v.requestFocus();
                v.requestFocusFromTouch();
            }
        });

        Button geiyao=(Button)findViewById(R.id.bt_geiyao);
        geiyao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setFocusable(true);
                v.requestFocus();
                v.requestFocusFromTouch();
            }
        });

        Button paixie=(Button)findViewById(R.id.bt_paixie);
        paixie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setFocusable(true);
                v.requestFocus();
                v.requestFocusFromTouch();
            }
        });

        Button shuifen=(Button)findViewById(R.id.bt_shuifen);
        shuifen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setFocusable(true);
                v.requestFocus();
                v.requestFocusFromTouch();
            }
        });

        Button yinshi=(Button)findViewById(R.id.bt_yinshi);
        yinshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setFocusable(true);
                v.requestFocus();
                v.requestFocusFromTouch();
            }
        });
    }
}
