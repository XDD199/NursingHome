package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IDSetting extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.id_setting);

    }
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.title_back:
                intent = new Intent(this, PersonalCenter.class);
                startActivity(intent);
                break;
            case R.id.exit:
                intent = new Intent(this, EnterActivity.class);
                startActivity(intent);
                break;

            default:
        }
    }
}
