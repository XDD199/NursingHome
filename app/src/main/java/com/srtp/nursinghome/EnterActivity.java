package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import dbForLry.Login_user;

public class EnterActivity extends AppCompatActivity {

    private EditText mEtLoginUsername;
    private EditText mEtLoginPassword;
    private ImageButton mBtLoginEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        mBtLoginEnter = findViewById(R.id.imagebutton_enter1);
        mEtLoginUsername = findViewById(R.id.edittext_enter1);
        mEtLoginPassword = findViewById(R.id.edittext_enter2);
        String[] stAccount ={"5300","1316","4972"};

        //设置点击事件监听器
        mBtLoginEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEtLoginUsername.getText().toString().equals("")&&mEtLoginPassword.getText().toString().equals("")){
                    Toast.makeText(EnterActivity.this,"请输入你的用户名或密码",Toast.LENGTH_SHORT).show();
                }else{
                    String account = mEtLoginUsername.getText().toString().trim();
                    String password = mEtLoginPassword.getText().toString().trim();
                    //账号5300
                    if (    (account.equals("5300")&& password.equals("123456")) ||
                            (account.equals("1316")&& password.equals("123456")) ||
                            (account.equals("4976")&& password.equals("123456")) ||
                            (account.equals("4")&& password.equals("123456"))
                    )
                    {
                        Intent intent=new Intent(EnterActivity.this,HomePage.class);
                        startActivity(intent);
                        Toast.makeText(EnterActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                    }

                    else{
                        Toast.makeText(EnterActivity.this,"用户名或密码不正确，请重新输入",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
