package com.example.quanlisv.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quanlisv.R;
import com.example.quanlisv.adapter.ChuongTrinhDaoTaoAdapter;
import com.example.quanlisv.model.ChuongTrinhDaoTao;

import java.util.ArrayList;

public class ChuongTrinhDaoTaoActivity extends AppCompatActivity {
        RecyclerView rcl_hocphan;
        ArrayList<ChuongTrinhDaoTao> listnoidung;
        ChuongTrinhDaoTaoAdapter chuongTrinhDaoTaoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuong_trinh_dao_tao);

    }
    public void InitView(){
        rcl_hocphan = (RecyclerView)findViewById(R.id.rcl_hocphan);
        listnoidung =  new ArrayList<>();
        listnoidung.add(new ChuongTrinhDaoTao(R.drawable.book,R.drawable.arrow,"dsafsdfasdfo tạo"));
        listnoidung.add(new ChuongTrinhDaoTao(R.drawable.dangkihp,R.drawable.arrow,"Đăng ádfasdfasdfần"));
        listnoidung.add(new ChuongTrinhDaoTao(R.drawable.profiles,R.drawable.arrow,"Thông tádfasdfng kí"));
        rcl_hocphan.setHasFixedSize(true);
        rcl_hocphan.setLayoutManager(new LinearLayoutManager(this));
        chuongTrinhDaoTaoAdapter = new ChuongTrinhDaoTaoAdapter(listnoidung,ChuongTrinhDaoTaoActivity.this);
        rcl_hocphan.setAdapter(chuongTrinhDaoTaoAdapter);
    }
}
