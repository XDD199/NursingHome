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

public class PersonalAboutus extends AppCompatActivity {

    private String[] data ={"版本更新","官网","隐私保护指引"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_aboutus);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                PersonalAboutus.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.personal_list);
        listView.setAdapter(adapter);

        ImageButton toId=(ImageButton)findViewById(R.id.head);
        toId.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PersonalAboutus.this,IDSetting.class);
                startActivity(intent);
            }
        });

    }
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.Button_personal_aboutus_return:
                intent = new Intent(this, PersonalAboutus.class);
                startActivity(intent);
                break;
            case R.id.Button_PrivacyPolicy:
                intent = new Intent(this, PrivacyPolicy.class);
                startActivity(intent);
                break;
            case R.id.Button_ServiceAgreement:
                intent = new Intent(this, nurse_notebook_read_supple.class);
                startActivity(intent);
                break;

            default:
        }
    }
}

