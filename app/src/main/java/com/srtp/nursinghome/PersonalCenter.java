package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

public class PersonalCenter extends AppCompatActivity {

    private String[] data ={"通知","自定义主题颜色","提醒设置","使用帮助","问题反馈","关于我们"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_center);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                PersonalCenter.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.personal_list);
        listView.setAdapter(adapter);

        ImageButton toId=(ImageButton)findViewById(R.id.head);
        toId.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PersonalCenter.this,IDSetting.class);
                startActivity(intent);
            }
        });

        Button toHome=(Button)findViewById(R.id.bottom_firstpage);
        toHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PersonalCenter.this,HomePage.class);
                startActivity(intent);
            }
        });

        Button toRecord=(Button)findViewById(R.id.bottom_workdata);
        toRecord.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PersonalCenter.this,BioMeasuren.class);
                startActivity(intent);
            }
        });

    }
}
