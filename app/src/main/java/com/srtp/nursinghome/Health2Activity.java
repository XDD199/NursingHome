package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.Calendar;

public class Health2Activity extends AppCompatActivity implements DatePicker.OnDateChangedListener {
    private DatePicker datepicker;
    private Calendar calendar=null;
    private int year;
    private int month;
    private int day;
    Button choose;
    private StringBuffer date;
    private Context context;

    private PopupMenu popupMenu;
    //TextView dateDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health2);

        //更改标题栏文字
        TextView title_text = (TextView) findViewById(R.id.title_text);
        title_text.setText("健康记录");

        //日期选择器初始化和变化监听
        //choose=(Button)findViewById(R.id.button_health22);
        choose=(Button)findViewById(R.id.time_health);
        //datepicker=(DatePicker)findViewById(R.id.datepicker_health2);
        context=this;
        initView();
        choose.setText(year+"-"+month+"-"+day);

        //exchange
        Button exchange=(Button)findViewById(R.id.button_health21);
        exchange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Health2Activity.this,HealthActivity.class);
                startActivity(intent);
            }
        });

        Button back=(Button)findViewById(R.id.title_back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Health2Activity.this,   MessageActivity.class);
                startActivity(intent);
            }
        });



    }

    private void initView(){
        calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH)+1;
        day=calendar.get(Calendar.DAY_OF_MONTH);
        //choose.setOnClickListener();
    }
    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear,int dayOfMonth){
        this.year=year;
        this.month=monthOfYear;
        this.day=dayOfMonth;
    }

    public void monClick(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               // if (date.length() > 0) { //清除上次记录的日期
                 //   date.delete(0, date.length());
                //}
                //choose.setText(date.append(String.valueOf(year)).append("年").append(String.valueOf(month)).append("月").append(day).append("日"));
                choose.setText(year+"-"+month+"-"+day);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        final AlertDialog dialog = builder.create();
        View dialogView = View.inflate(context, R.layout.date_health, null);
        final DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.datePicker_health);
        dialog.setTitle("设置日期");
        dialog.setView(dialogView);
        dialog.show();
        //初始化日期监听事件
        datePicker.init(year, month - 1, day, this);
    }

    public boolean onCreateOptionsMenu(Menu menu)//开发选项菜单重写的方法
    {
        MenuInflater inflater = new MenuInflater(this);//菜单动态加载类
        inflater.inflate(R.menu.menu_title, menu);//调用inflate方法解析菜单文件
        //super.onCreateOptionsMenu(menu);
        return true;
    }

    /*
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            switch (R.menu.menu_title) {
                case R.id.basic_menu:

                    Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.health_menu:
                    Toast.makeText(this, "扫一扫", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.care_munu:
                    Toast.makeText(this, "字体颜色", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            return super.onOptionsItemSelected(item);
        }

     */
/*
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        getMenuInflater().inflate(R.menu.menu_title, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

*/
    public void menu_right(View view) {
        // TODO Auto-generated method stub

        popupMenu = new PopupMenu(this, view);
        getMenuInflater().inflate(R.menu.menu_title, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // TODO Auto-generated method stub
                switch (item.getItemId()) {
                    case R.id.basic_menu:
                        Intent intent1=new Intent(Health2Activity.this,BasicActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.health_menu:
                        Intent intent2=new Intent(Health2Activity.this,HealthActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.care_munu:
                        //Intent intent3=new Intent(BasicActivity.this,BasicActivity.class);
                        //startActivity(intent3);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        popupMenu.show();
    }


}
