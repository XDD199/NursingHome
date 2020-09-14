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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import dbForLry.JDBCUtils;
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
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            boolean loginSuccess = false;

                            try {
                                Connection connection = JDBCUtils.getConnection();
                                System.out.println(connection);
                                PreparedStatement pstmt = connection.prepareStatement("select * from workers where w_id=? and w_password=?");
                                pstmt.setString(1,account);
                                pstmt.setString(2,password);

                                ResultSet rs = pstmt.executeQuery();
                                boolean isUserFound = rs.next();
                                if (isUserFound) {
                                    String username = rs.getString("w_id");
                                    String pwd = rs.getString("w_password");
                                    if (account.equals(username) && password.equals(pwd)) {
                                        loginSuccess = true;
                                    }
                                }


                                //账号5300
                                if (loginSuccess)
                                {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Intent intent=new Intent(EnterActivity.this,HomePage.class);
                                            startActivity(intent);
                                            Toast.makeText(EnterActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                                else{
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(EnterActivity.this,"用户名或密码不正确，请重新输入",Toast.LENGTH_SHORT).show();
                                        }
                                    });

                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                                System.err.println("创建数据库连接异常.");
                            }
                        }
                    }).start();

                }
            }
        });
    }

}
