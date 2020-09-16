package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkTodoActivity extends AppCompatActivity{

    private ListView listview;

    //用户点击确定按钮时执行的函数
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_todo);
        //初始化页面对象
        init();
        //将数据显示在页面上
        initDate();

        //按钮
        Button toHome=(Button)findViewById(R.id.worktodo_title_back);
        toHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(WorkTodoActivity.this,HomePage.class);
                startActivity(intent);
            }
        });

        ListView lv_workdata = (ListView)this.findViewById(R.id.lv_workdata);
        System.out.println(lv_workdata);

    }

    public void init(){
        listview = (ListView) findViewById(R.id.lv_workdata);
    }


    public void initDate(){
        //准备数据源
        List<Map<String, Object>> lv_workdata = new ArrayList<Map<String, Object>>();
        Map map = new HashMap<String, Object>();
        map.put("work_event", " 协助老人起床、洗漱 ");
        map.put("event_time", "6：30");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 餐前给药、血压测量 ");
        map.put("event_time", "7：15");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 早餐，观察并记录饮食情况 ");
        map.put("event_time", "7：30");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 餐后给药、血压测量 ");
        map.put("event_time", "7：45");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 床头交接 ");
        map.put("event_time", "8：00");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 中餐，观察并记录饮食情况 ");
        map.put("event_time", "11：00");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 午休，巡视 ");
        map.put("event_time", "12：00——14：30");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 个人卫生清洁 ");
        map.put("event_time", "14：45");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 晚餐，观察并记录饮食情况 ");
        map.put("event_time", "16：30");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 晚餐后的给药、血压测量等 ");
        map.put("event_time", "18：00——20：00");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 协助老人夜间休息 ");
        map.put("event_time", "21：00");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 夜间护理、巡视 ");
        map.put("event_time", "21：00——6：30");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 饮食水分 ");
        map.put("event_time", "全天");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 老人排泄 ");
        map.put("event_time", "全天");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 来访/物品登记 ");
        map.put("event_time", "全天");
        lv_workdata.add(map);

        map = new HashMap<String, Object>();
        map.put("work_event", " 环境物品消毒 ");
        map.put("event_time", "全天");
        lv_workdata.add(map);

        //准备适配器TodoAdapter
        TodoAdapter adapter = new TodoAdapter(lv_workdata, this);
        adapter.setLv_workdata(lv_workdata);

        //将适配器关联到listview
        listview.setAdapter(adapter);

    }

}

