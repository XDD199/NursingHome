package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
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

    }
}
