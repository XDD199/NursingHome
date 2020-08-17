package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UsingHelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_usinghelp);
        getSupportActionBar().hide();
    }
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.Button_personal_usinghelp_return:
                intent = new Intent(this, PersonalCenter.class);
                startActivity(intent);
                break;

            default:
        }
    }
}


