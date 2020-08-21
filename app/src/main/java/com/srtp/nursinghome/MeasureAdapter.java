package com.srtp.nursinghome;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static androidx.core.content.ContextCompat.startActivities;
import static androidx.core.content.ContextCompat.startActivity;

public class MeasureAdapter extends RecyclerView.Adapter<MeasureAdapter.ViewHolder> {
    private List<Old> mOldList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView oldImage;
        TextView oldName;
        TextView oldId;
        View oldView;

        public ViewHolder(View view){
            super(view);
            oldView=view;
            oldImage=(ImageView)view.findViewById(R.id.old_image);
            oldName=(TextView)view.findViewById(R.id.old_name);
            oldId=(TextView)view.findViewById(R.id.old_id);
        }
    }

    public MeasureAdapter(List<Old> oldList){
        mOldList=oldList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.old_item,parent,false);
        // ViewHolder holder=new ViewHolder(view);
        final ViewHolder holder=new ViewHolder(view);

        holder.oldImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Old old=mOldList.get(position);
                Context mContext=view.getContext();
                Intent intent=new Intent(mContext,DataRecording.class);
                mContext.startActivity(intent);
            }
        });



        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Old old=mOldList.get(position);
        holder.oldImage.setBackgroundResource(old.getImageId());
        holder.oldName.setText(old.getName());
        holder.oldId.setText(old.getId());
    }

    @Override
    public int getItemCount() {
        return mOldList.size();
    }


}
