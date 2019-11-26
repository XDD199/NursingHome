package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class BasicActivity extends AppCompatActivity {
    //cd
    private PopupMenu popupMenu;
    private Button menu_button;
    //private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        //菜单
        //tv=(TextView)findViewById(R.id.tv);
        menu_button=(Button)findViewById(R.id.title_menu);
        //registerForContextMenu(tv);

        //更改标题栏文字
        TextView title_text=(TextView)findViewById(R.id.title_text);
        title_text.setText("基本信息");

    }

    //标题栏的菜单
    //在JAVA文件中对资源文件进行加载
    public boolean onCreateOptionsMenu(Menu menu)//开发选项菜单重写的方法
    {
        MenuInflater inflater = new MenuInflater(this);//菜单动态加载类
        inflater.inflate(R.menu.menu_title,menu);//调用inflate方法解析菜单文件
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
                switch (R.menu.menu_title) {
                    case R.id.basic_menu:
                        Toast.makeText(BasicActivity.this, "setting", Toast.LENGTH_SHORT);
                        break;
                    case R.id.health_menu:
                        Toast.makeText(BasicActivity.this, "扫一扫", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.care_munu:
                        Toast.makeText(BasicActivity.this, "字体颜色", Toast.LENGTH_SHORT).show();
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
