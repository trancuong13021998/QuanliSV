package com.example.quanlisv.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlisv.R;
import com.example.quanlisv.adapter.AdminTrangChuAdapter;
import com.example.quanlisv.model.SubFuntion;

import java.util.ArrayList;

public class AdminTrangChu extends AppCompatActivity {
        RecyclerView rcl_trangchuadmin;
        ArrayList<SubFuntion> listnoidungtrangchu;
        AdminTrangChuAdapter admintrangchuadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_trang_chu);
        TrangchuAdmin();
    }
    public void TrangchuAdmin(){
        rcl_trangchuadmin = (RecyclerView)findViewById(R.id.rcltrangchuadmin);
        listnoidungtrangchu = new ArrayList<>();
        listnoidungtrangchu.add(new SubFuntion(R.drawable.book, R.drawable.arrow,"chương trình đào tạo"));
        listnoidungtrangchu.add(new SubFuntion(R.drawable.sinhvien, R.drawable.arrow,"Danh sách sinh viên"));
        admintrangchuadapter =  new AdminTrangChuAdapter(listnoidungtrangchu,AdminTrangChu.this);
        rcl_trangchuadmin.setHasFixedSize(true);
        rcl_trangchuadmin.setLayoutManager(new LinearLayoutManager(this));
        rcl_trangchuadmin.setAdapter(admintrangchuadapter);
    }
}
