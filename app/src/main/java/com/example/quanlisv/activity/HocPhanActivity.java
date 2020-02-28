package com.example.quanlisv.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quanlisv.R;
import com.example.quanlisv.adapter.AdminTrangChuAdapter;
import com.example.quanlisv.adapter.HocPhanAdapter;
import com.example.quanlisv.model.SubFuntion;

import java.util.ArrayList;

public class HocPhanActivity extends AppCompatActivity {
    RecyclerView rcl_hocphan;
    ArrayList<SubFuntion> listnoidung;
    HocPhanAdapter hocphanadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_phan);
        InitView();
    }
    public void InitView(){
        rcl_hocphan = (RecyclerView)findViewById(R.id.rcl_hocphan);
        listnoidung =  new ArrayList<>();
        listnoidung.add(new SubFuntion(R.drawable.book,R.drawable.arrow,"Chương trình đào tạo"));
        listnoidung.add(new SubFuntion(R.drawable.dangkihp,R.drawable.arrow,"Đăng kí học phần"));
        listnoidung.add(new SubFuntion(R.drawable.profiles,R.drawable.arrow,"Thông tin học phần đăng kí"));
        rcl_hocphan.setHasFixedSize(true);
        rcl_hocphan.setLayoutManager(new LinearLayoutManager(this));
        hocphanadapter = new HocPhanAdapter(listnoidung,HocPhanActivity.this);
        rcl_hocphan.setAdapter(hocphanadapter);
    }
}
