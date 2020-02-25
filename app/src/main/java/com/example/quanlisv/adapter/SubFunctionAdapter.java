package com.example.quanlisv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlisv.R;
import com.example.quanlisv.model.SubFuntion;

import java.util.List;

public class SubFunctionAdapter extends RecyclerView.Adapter<SubFunctionAdapter.ViewHolder> {
    List<SubFuntion> subFuntionList;
    public SubFunctionAdapter(List<SubFuntion> hocPhanSVList) {
        this.subFuntionList = hocPhanSVList;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sub_funtion,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubFuntion subFuntion= subFuntionList.get(position);
        holder.imgIcon.setImageResource(subFuntion.getImg1());
        holder.imgChange.setImageResource(subFuntion.getAnh2());
        holder.txtNoidung.setText(hocPhanSV.getNdhocphan());
    }

    @Override
    public int getItemCount() {
        return hocPhanSVList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgChange,imgIcon;
        TextView txtNoidung;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgChange=(ImageView)itemView.findViewById(R.id.imgChange);
            imgIcon = (ImageView)itemView.findViewById(R.id.imgIcon);
            txtNoidung = (TextView)itemView.findViewById(R.id.txtNoidung);

        }
    }{

}
