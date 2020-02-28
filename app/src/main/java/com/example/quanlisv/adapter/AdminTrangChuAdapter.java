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
import com.example.quanlisv.activity.AdminChuongTrinhDaoTaoActivity;
import com.example.quanlisv.activity.AdminDanhSachSV;
import com.example.quanlisv.activity.ChuongTrinhDaoTaoActivity;
import com.example.quanlisv.model.ChuongTrinhDaoTao;
import com.example.quanlisv.model.SubFuntion;

import java.util.List;

public class AdminTrangChuAdapter extends RecyclerView.Adapter<AdminTrangChuAdapter.ViewHolder> {
    List<SubFuntion> subFuntionList;
    Context context;
    public AdminTrangChuAdapter(List<SubFuntion> hocPhanSVList, Context context) {
        this.subFuntionList = hocPhanSVList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sub_funtion,parent,false);
        return new ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final SubFuntion subFuntion= subFuntionList.get(position);
        holder.imgIcon.setImageResource(subFuntion.getImg1());
        holder.imgChange.setImageResource(subFuntion.getImg2());
        holder.txtNoidung.setText(subFuntion.getNoidung());
        holder.subfunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Intent intent1 = new Intent(context, AdminChuongTrinhDaoTaoActivity.class);
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent1);
                        break;
                    case 1:
                        Intent intent = new Intent(context, AdminDanhSachSV.class);
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

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgChange,imgIcon;
        TextView txtNoidung;
        LinearLayout subfunction;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgChange=(ImageView)itemView.findViewById(R.id.img_change);
            imgIcon = (ImageView)itemView.findViewById(R.id.img_back);
            txtNoidung = (TextView)itemView.findViewById(R.id.txtNoidung);
            subfunction = (LinearLayout)itemView.findViewById(R.id.dong_subfunction);
        }
    }

}
