package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrivacyPolicy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacypolicy);
        getSupportActionBar().hide();
    }
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.Button_privacypolicy_return:
                intent = new Intent(this, PersonalAboutus.class);
                startActivity(intent);
                break;

            default:
        }
    }
}



