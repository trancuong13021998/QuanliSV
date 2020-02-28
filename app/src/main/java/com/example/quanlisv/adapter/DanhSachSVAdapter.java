package com.example.quanlisv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlisv.R;
import com.example.quanlisv.activity.AdminDanhSachSV;
import com.example.quanlisv.model.DanhSachSV;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DanhSachSVAdapter extends RecyclerView.Adapter <DanhSachSVAdapter.ViewHolder>{
    Context context;
    ArrayList<DanhSachSV> danhSachSVArrayList;

    public DanhSachSVAdapter(Context context, ArrayList<DanhSachSV> danhSachSVArrayList) {
        this.context = context;
        this.danhSachSVArrayList = danhSachSVArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sinhvien,parent,false);
        return  new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DanhSachSV danhSachSV = danhSachSVArrayList.get(position);
        holder.txt_tensv.setText(danhSachSV.getTensv());
        holder.txt_masv.setText(Integer.toString(danhSachSV.getMasv()));
        holder.txt_lopsv.setText(danhSachSV.getLopsv());
        holder.txt_khoasv.setText(danhSachSV.getKhoasv());
        holder.txt_sodutk.setText(danhSachSV.getSodutaikoan());
        holder.txt_pass.setText(Integer.toString(danhSachSV.getPass()));
        Picasso.with(context).load(danhSachSV.getAnhsv()).into(holder.img_sv);

    }

    @Override
    public int getItemCount() {
        return danhSachSVArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_masv,txt_tensv,txt_lopsv,txt_khoasv,txt_sodutk,txt_pass;
        CircleImageView img_sv;
        ImageView img_edit,img_delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_delete = (ImageView) itemView.findViewById(R.id.img_delete);
            img_edit = (ImageView)itemView.findViewById(R.id.img_edit);
            txt_tensv = (TextView)itemView.findViewById(R.id.txt_tensv1);
            txt_masv = (TextView)itemView.findViewById(R.id.txt_masv1);
            txt_lopsv = (TextView)itemView.findViewById(R.id.txt_lopsv1);
            txt_khoasv = (TextView)itemView.findViewById(R.id.txt_khoasv1);
            txt_sodutk = (TextView)itemView.findViewById(R.id.txt_sodutk1);
            txt_pass = (TextView)itemView.findViewById(R.id.txt_pass1);
            img_sv= (CircleImageView)itemView.findViewById(R.id.img_sv1);
        }
    }
}

