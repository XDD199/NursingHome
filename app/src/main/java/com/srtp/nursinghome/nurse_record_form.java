package com.example.to_work;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

public class nurse_record_form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_record_form);


    }
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.Button_form_return:
                intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.Button_form_change:
                intent=new Intent(this,nurse_record_calendar.class);
                startActivity(intent);
                break;
            default:
        }
    }


}
