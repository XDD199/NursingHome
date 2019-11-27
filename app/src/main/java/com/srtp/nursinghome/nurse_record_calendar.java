package com.example.to_work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class nurse_record_calendar extends AppCompatActivity {

    private Spinner nurse_record_calendar_year = null;
    private Spinner nurse_record_calendar_month = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_record_calendar);
        getSupportActionBar().hide();
        //获取界面布局文件中的Spinner组件
        nurse_record_calendar_year=(Spinner) findViewById(R.id.spin_nurse_record_calendar_year);
        nurse_record_calendar_month=(Spinner)findViewById(R.id.spin_nurse_record_calendar_month);


    }
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.Button_calendar_return:
                intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.Button_calendar_change:
                intent=new Intent(this,nurse_record_form.class);
                startActivity(intent);
                break;
            default:
        }
    }

}
