package com.srtp.nursinghome;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatCheckBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbForLry.JDBCUtils;

public class TodoAdapter extends BaseAdapter {
    //填充数据的list
    private List<Map<String, Object>> lv_workdata;
    //用来导入布局
    private LayoutInflater inflater;
    //上下文
    private Context context;
    //用来记录checkbox选中与否
    private Map<Integer, Boolean> map = new HashMap<>();

    private Connection connection;

    private String update_schedule_sch_judge_sql = "UPDATE schedule set sch_judge=? where sch_shunxu=?";

    private final double finished = 1.0d;
    private final double unfinished = 0.0d;

    //--构造器上下文--
    public TodoAdapter(List<Map<String, Object>> lv_workdata, Context context) {
        this.context = context;
        this.lv_workdata = lv_workdata;
        inflater = LayoutInflater.from(context);
        try{
        if (null == connection || connection.isClosed()) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection = JDBCUtils.getConnection();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }}catch (Exception e){
            e.printStackTrace();
        }
    }

    //--传入数据集合--
    public void setLv_workdata(List<Map<String, Object>> lv_workdata) {
        this.lv_workdata = lv_workdata;
    }

    //--自定义TodoAdapter
    @Override
    public int getCount() {
        return lv_workdata.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //构造一个view
        View view;
        if (convertView == null) {
            //通过一个inflate可以把一个布局转换成一个view对象
            view = inflater.inflate(R.layout.item_workdata, null);
        } else {
            view = convertView;         //复用历史缓存对象
        }

        //获取各个控件
        CheckBox work_event = (CheckBox) view.findViewById(R.id.cb_todo);
        TextView event_time = (TextView) view.findViewById(R.id.event_time);

        //给控件赋值
        work_event.setText((String) lv_workdata.get(position).get("work_event"));
        event_time.setText((String) lv_workdata.get(position).get("event_time"));

        work_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    new Thread(new Runnable() {
                        @RequiresApi(api = Build.VERSION_CODES.N)
                        @Override
                        public void run() {
                            PreparedStatement pstmt = null;
                            try {
                                System.out.println(update_schedule_sch_judge_sql);
                                pstmt = connection.prepareStatement(update_schedule_sch_judge_sql);
                                System.out.println("position : " + position + " is checked.");
                            if (work_event.isChecked()) {

                                pstmt.setDouble(1, finished);
                                pstmt.setInt(2, position + 1);
                                map.put(position,true);

                            }else{
                                pstmt.setDouble(1, unfinished);
                                pstmt.setInt(2, position + 1);
                                map.put(position,false);

                            }
                                int rs = pstmt.executeUpdate();

                                if (rs == 1) {
                                    System.out.println("更新状态成功: " + position );
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
//               work_event.isSelected()
            }
        });
        if (map != null && map.containsKey(position)) {
            work_event.setChecked(true);
        } else {
            work_event.setChecked(false);
        }
        return view;
    }


}
