package com.example.quanlisv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlisv.R;
import com.example.quanlisv.model.ChuongTrinhDaoTao;
import com.example.quanlisv.model.SubFuntion;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.List;
public class ChuongTrinhDaoTaoAdapter extends RecyclerView.Adapter<ChuongTrinhDaoTaoAdapter.ViewHolder> {
    ArrayList<ChuongTrinhDaoTao> chuongTrinhDaoTaoList;
    Context context;
    public ChuongTrinhDaoTaoAdapter(ArrayList<ChuongTrinhDaoTao> chuongTrinhDaoTaoList, Context context) {
        this.chuongTrinhDaoTaoList = chuongTrinhDaoTaoList;
        this.context = context;
    }
    @NonNull
    @Override
    public ChuongTrinhDaoTaoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_chuong_trinh_dao_tao,parent,false);
        return new ChuongTrinhDaoTaoAdapter.ViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final ChuongTrinhDaoTao chuongTrinhDaoTao= chuongTrinhDaoTaoList.get(position);
        holder.imgIcon.setImageResource(chuongTrinhDaoTao.getImg1());
        holder.imgChange.setImageResource(chuongTrinhDaoTao.getImg2());
        holder.txtNoidung.setText(chuongTrinhDaoTao.getNoidung());
    }
    @Override
    public int getItemCount() {
        return chuongTrinhDaoTaoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgChange,imgIcon;
        TextView txtNoidung;
        LinearLayout chuongTrinhDaoTao ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgChange=(ImageView)itemView.findViewById(R.id.img_change1);
            imgIcon = (ImageView)itemView.findViewById(R.id.img_back1);
            txtNoidung = (TextView)itemView.findViewById(R.id.txtNoidung1);
            chuongTrinhDaoTao = (LinearLayout)itemView.findViewById(R.id.dong_chuong_trinh_dao_tao);
        }
    }

}
