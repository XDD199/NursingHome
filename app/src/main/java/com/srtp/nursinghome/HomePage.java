package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        //按钮 界面
        Button toOldMessage=(Button)findViewById(R.id.block1);
        toOldMessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,MessageActivity.class);
                startActivity(intent);
            }
        });

        Button toWorkTodo=(Button)findViewById(R.id.block2);
        toWorkTodo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,WorkTodoActivity.class);
                startActivity(intent);
            }
        });

        Button toCalendar=(Button)findViewById(R.id.title_calendar);
        toCalendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,CalendarActivity.class);
                startActivity(intent);
            }
        });


        Button toLog=(Button)findViewById(R.id.block3);
        toLog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,nurse_notebook.class);
                startActivity(intent);
            }
        });

        Button toHome=(Button) findViewById(R.id.bottom_firstpage);
        toHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,HomePage.class);
                startActivity(intent);
            }
        });

        Button toRecord=(Button) findViewById(R.id.bottom_workdata);
        toRecord.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,BioMeasuren.class);
                startActivity(intent);
            }
        });

        Button toPersonal=(Button)findViewById(R.id.bottom_personalcenter);
        toPersonal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,PersonalCenter.class);
                startActivity(intent);
            }
        });


    }
}
