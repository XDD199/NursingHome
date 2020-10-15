package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.Statement;

public class nurse_book_write extends AppCompatActivity {
    private String edit_ORsituation;
    private String edit_IDsituation;
    private  String year;
    private  String month;
    private  String day;
    private  String dayornight;
    private  String floor;

    private EditText overallsituation;
    private EditText individualsituation;
    private Spinner writeyear;
    private Spinner writemonth;
    private Spinner writeday;
    private Spinner writedayornight;
    private Spinner writefloor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nurse_book_write);
        //getSupportActionBar().hide();
        new Thread(new Runnable() {
            @Override
            public void run() {
                MysqlTest.main();
            }
        }).start();

    }


    public void onClick(View v) {
        Intent intent;
        overallsituation=(EditText)findViewById(R.id.notebook_write_overallsituation);
        individualsituation=(EditText)findViewById(R.id.notebook_write_individualsituation);
        writeyear=(Spinner)findViewById(R.id.spin_nurse_record_calendar_year);
        writemonth=(Spinner)findViewById(R.id.spin_nurse_record_calendar_month);
        writeday=(Spinner)findViewById(R.id.spin_nurse_record_calendar_day);
        writedayornight=(Spinner)findViewById(R.id.spin_nurse_record_calendar_dayornight);
        writefloor=(Spinner)findViewById(R.id.spin_nurse_record_calendar_floor);
        switch(v.getId()){
            case R.id.Button_notebook_write_return:
                intent=new Intent(this,nurse_notebook.class);
                startActivity(intent);
                break;

            case R.id.Button_notebook_write_finish:
                intent=new Intent(this,nurse_notebook.class);
                year= (String) writeyear.getSelectedItem();
                month = (String) writemonth.getSelectedItem();
                day = (String) writeday.getSelectedItem();
                dayornight = (String) writedayornight.getSelectedItem();
                floor = (String) writefloor.getSelectedItem();
                edit_ORsituation=overallsituation.getText().toString();
                edit_IDsituation=individualsituation.getText().toString();



                startActivity(intent);
                break;
            default:
        }
    }


}
