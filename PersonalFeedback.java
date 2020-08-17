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

public class PersonalFeedback extends AppCompatActivity {

    private String[] data ={"为什么跳转卡死呢","为什么有的按键失效呢","为什么会经常闪退呢","为什么会出现乱码呢"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_feedback);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                PersonalFeedback.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.personal_list);
        listView.setAdapter(adapter);

        ImageButton toId=(ImageButton)findViewById(R.id.head);
        toId.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PersonalFeedback.this,IDSetting.class);
                startActivity(intent);
            }
        });

    }
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.Button_personal_feedback_return:
                intent = new Intent(this, PersonalCenter.class);
                startActivity(intent);
                break;

            default:
        }
    }
}

