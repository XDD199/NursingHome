package com.srtp.nursinghome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OldAdapter extends RecyclerView.Adapter<OldAdapter.ViewHolder> {
    private List<Old> mOldList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        Button oldImage;
        TextView oldName;
        TextView oldId;

        public ViewHolder(View view){
            super(view);
            oldImage=(Button)view.findViewById(R.id.old_image);
            oldName=(TextView)view.findViewById(R.id.old_name);
            oldId=(TextView)view.findViewById(R.id.old_id);
        }
    }

    public OldAdapter(List<Old> oldList){
        mOldList=oldList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.old_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
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
