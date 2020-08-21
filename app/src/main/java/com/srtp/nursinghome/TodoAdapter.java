package com.srtp.nursinghome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class TodoAdapter extends BaseAdapter{

    List<Map<String, Object>> lv_workdata;
    LayoutInflater inflater;

    //--构造器上下文--
    public TodoAdapter (Context context){
        inflater = LayoutInflater.from(context);
    }

    //--传入数据集合--
    public void setLv_workdata(List<Map<String, Object>> lv_workdata){
        this.lv_workdata = lv_workdata;
    }

    //--自定义TodoAdapter
    @Override
    public int getCount() {
        return lv_workdata.size();
    }

    @Override
    public Object getItem(int position){
        return lv_workdata.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //构造一个view
        View view = inflater.inflate(R.layout.item_workdata, null);

        //获取各个控件
        TextView work_event = (TextView) view.findViewById(R.id.work_event);
        TextView event_time = (TextView) view.findViewById(R.id.event_time);

        //给控件赋值
        work_event.setText((String) lv_workdata.get(position).get("work_event"));
        event_time.setText((String) lv_workdata.get(position).get("event_time"));

        return view;
    }
}
