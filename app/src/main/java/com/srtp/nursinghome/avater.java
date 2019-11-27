package com.example.to_work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class avater extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avater);
        getSupportActionBar().hide();
    }

    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.Button_avatar_return:
                intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        default:
        }
    }
}
