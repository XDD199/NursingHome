package com.example.to_work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class nurse_book_write extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_book_write);
        getSupportActionBar().hide();
    }


    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.Button_notebook_write_return:
                intent=new Intent(this,nurse_notebook.class);
                startActivity(intent);
                break;

            case R.id.Button_notebook_write_finish:
                intent=new Intent(this,nurse_notebook.class);
                startActivity(intent);
                break;
            default:
        }
    }
}
