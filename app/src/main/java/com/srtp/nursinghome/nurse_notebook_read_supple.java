package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class nurse_notebook_read_supple extends AppCompatActivity {
    private String edit_supply;

    private Button enter;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_notebook_read_supple);
        //getSupportActionBar().hide();
    }

    public void onClick(View v) {
        Intent intent;
        enter.setOnClickListener((View.OnClickListener) this);
        input=(EditText)findViewById(R.id.notebook_supple_text);
        edit_supply=input.getText().toString();
        switch (v.getId()) {
            case R.id.Button_notebook_supple_return:
                intent = new Intent(this, nurse_notebook_read.class);
                startActivity(intent);
                break;
            case R.id.Button_notebook_supple_ok:
                intent = new Intent(this, nurse_notebook_read.class);
                startActivity(intent);
                break;
            default:
        }

    }
}
