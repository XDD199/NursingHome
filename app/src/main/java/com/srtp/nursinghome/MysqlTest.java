package com.srtp.nursinghome;

//import android.database.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class MysqlTest {
    public static void main(String[] args) {
        Connection con;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://rm-bp1tymfixa12tydv42o.mysql.rds.aliyuncs.com:3306/sqtp_one?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false";
        String user = "sqtp_456";
        String password = "sqtp123456";
        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url,user,password);
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");

            Statement statement = con.createStatement();

            String sql = "select * from workers";

            ResultSet rs = statement.executeQuery(sql);
            System.out.println("-------");
            System.out.println("执行结果如下所示：");
            System.out.println("--------");
            System.out.println("姓名"+"\t"+"账号"+"\t"+"密码");
            System.out.println("--------");

            String name = null;
            String id = null;
            String keypass = null;
            while (rs.next()){
                name = rs.getString("w_name");
                id = rs.getString("w_id");
                keypass = rs.getString("w_password");

                System.out.println(name+"\t"+id+"\t"+keypass);
            }
            rs.close();
            con.close();

        }catch (ClassNotFoundException e) {
            System.out.println("Sorry, can't find the driver");
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
           System.out.println("假的！数据库成功获取");
        }

    }
}
