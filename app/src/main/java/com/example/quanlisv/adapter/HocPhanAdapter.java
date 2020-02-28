package com.example.quanlisv.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlisv.R;
import com.example.quanlisv.activity.ChuongTrinhDaoTaoActivity;
import com.example.quanlisv.model.SubFuntion;

import java.util.List;

public class HocPhanAdapter extends RecyclerView.Adapter<HocPhanAdapter.ViewHolder>{
    List<SubFuntion> subFuntionList;
    Context context;

    public HocPhanAdapter(List<SubFuntion> subFuntionList, Context context) {
        this.subFuntionList = subFuntionList;
        this.context = context;
    }

    @NonNull
    @Override
    public HocPhanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sub_funtion,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HocPhanAdapter.ViewHolder holder, final int position) {
        SubFuntion subFuntion = subFuntionList.get(position);
        holder.txt_noidung.setText(subFuntion.getNoidung());
        holder.img_back.setImageResource(subFuntion.getImg1());
        holder.img_changge.setImageResource(subFuntion.getImg2());
        holder.itemlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Intent intent =  new Intent(context, ChuongTrinhDaoTaoActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return subFuntionList.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        TextView txt_noidung;
        ImageView img_changge,img_back;
        LinearLayout itemlayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_noidung = (TextView)itemView.findViewById(R.id.txtNoidung);
            img_changge = (ImageView) itemView.findViewById(R.id.img_change);
            img_back = (ImageView) itemView.findViewById(R.id.img_back);
            itemlayout = (LinearLayout)itemView.findViewById(R.id.dong_subfunction);
        }
    }
}
