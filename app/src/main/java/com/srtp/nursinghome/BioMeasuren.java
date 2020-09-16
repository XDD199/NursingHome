package com.srtp.nursinghome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class BioMeasuren extends AppCompatActivity {

    //RecyclerView
    private RecyclerView recyclerView;
    private List<Old> oldList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_measuren);

        Button toHome=(Button)findViewById(R.id.bottom_firstpage);
        toHome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BioMeasuren.this,HomePage.class);
                startActivity(intent);
            }
        });

        Button toPersonal=(Button)findViewById(R.id.bottom_personalcenter);
        toPersonal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BioMeasuren.this,PersonalCenter.class);
                startActivity(intent);
            }
        });

        //RecyclerView
        initOld();
        recyclerView=(RecyclerView)findViewById(R.id.rcv_message);
        StaggeredGridLayoutManager layoutManager=new
                StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        MeasureAdapter adapter=new MeasureAdapter(oldList);
        recyclerView.setAdapter(adapter);
    }
    //RecyclerView
    private void initOld(){
        Old wang=new Old("王老人","1号",R.drawable.cutehead);
        oldList.add(wang);
        Old li=new Old("李老人","2号",R.drawable.cutehead);
        oldList.add(li);
        Old sun=new Old("孙老人","3号",R.drawable.cutehead);
        oldList.add(sun);
        Old zhao=new Old("赵老人","4号",R.drawable.cutehead);
        oldList.add(zhao);
        Old qian=new Old("钱老人","5号",R.drawable.cutehead);
        oldList.add(qian);
        Old lin=new Old("林老人","6号",R.drawable.cutehead);
        oldList.add(lin);
        Old xu =new Old("许老人","7号",R.drawable.cutehead);
        oldList.add(xu);
        Old cai=new Old("蔡老人","8号",R.drawable.cutehead);
        oldList.add(cai);
        Old tian=new Old("田老人","9号",R.drawable.cutehead);
        oldList.add(tian);
        Old ou=new Old("欧老人","10号",R.drawable.cutehead);
        oldList.add(ou);
        Old yang=new Old("杨老人","11号",R.drawable.cutehead);
        oldList.add(yang);
        Old jiang=new Old("江老人","12号",R.drawable.cutehead);
        oldList.add(jiang);
    }
}
