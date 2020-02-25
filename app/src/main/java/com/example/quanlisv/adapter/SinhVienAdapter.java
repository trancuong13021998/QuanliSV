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
import com.example.quanlisv.activity.TrangchuActivity;
import com.example.quanlisv.model.SinhVien;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.ViewHolder> {
    List<SinhVien> sinhVienList;
    Context context;

    public SinhVienAdapter(List<SinhVien> sinhVienList,Context context) {
        this.sinhVienList = sinhVienList;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_sv,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SinhVien sinhVien= sinhVienList.get(position);
        holder.txt_masv.setText(Integer.toString(sinhVien.getMasv()));
        holder.txt_lopsv.setText(sinhVien.getLopsv());
        holder.txt_khoasv.setText(sinhVien.getKhoasv());
        Picasso.with(context).load(sinhVien.getAnhsv()).
                placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.img_sv);
        holder.txt_sodutk.setText(sinhVien.getSodutaikhoansv());
        holder.txt_tensv.setText("Xin chào, "+ sinhVien.getTensv());

    }

    @Override
    public int getItemCount() {
        return sinhVienList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_masv,txt_lopsv,txt_khoasv,txt_sodutk,txt_tensv;
        CircleImageView img_sv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_tensv = (TextView)itemView.findViewById(R.id.txt_tensv);
            txt_masv = (TextView)itemView.findViewById(R.id.txt_masv);
            txt_lopsv = (TextView)itemView.findViewById(R.id.txt_lopsv);
            txt_khoasv = (TextView)itemView.findViewById(R.id.txt_khoasv);
            txt_sodutk = (TextView)itemView.findViewById(R.id.txt_sodutk);
            img_sv= (CircleImageView)itemView.findViewById(R.id.img_sv);
        }
    }
}
