package com.example.to_work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class nurse_notebook_read extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_notebook_read);
        getSupportActionBar().hide();
    }
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.Button_notebook_read_return:
                intent = new Intent(this, nurse_notebook.class);
                startActivity(intent);
                break;
            case R.id.Button_notebook_supple:
                intent = new Intent(this, nurse_notebook_read_supple.class);
                startActivity(intent);
                break;

            default:
        }
    }
}
