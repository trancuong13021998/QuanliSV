package com.example.quanlisv.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.quanlisv.R;
import com.example.quanlisv.adapter.AdapterMenuMain;
import com.example.quanlisv.adapter.SinhVienAdapter;
import com.example.quanlisv.model.MenuMain;
import com.example.quanlisv.model.SinhVien;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.quanlisv.utility.Server.urlThongtinSv;

public class TrangchuActivity extends AppCompatActivity  {
    ArrayList<SinhVien> arrSinhvien;
    SinhVienAdapter sinhVienAdapter;
    ArrayList<MenuMain> arrmenu;
    AdapterMenuMain menuMain;
    RecyclerView recyclerView,recyclerView_menu;
    Toolbar toolbar;
    CardView cardView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        InitView();

        GetData();


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void InitView() {
        arrSinhvien = new ArrayList<>();
        sinhVienAdapter = new SinhVienAdapter(arrSinhvien,TrangchuActivity.this);
        recyclerView = (RecyclerView) findViewById(R.id.rclThongtin);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(sinhVienAdapter);

        arrmenu = new ArrayList<>();
        menuMain = new AdapterMenuMain(arrmenu,TrangchuActivity.this);


        arrmenu.add(new MenuMain("https://cdn-01.dhcnhn.vn/img/logo-haui-size.png","Học phần"+""));
        arrmenu.add(new MenuMain("https://cdn-01.dhcnhn.vn/img/logo-haui-size.png","Thời khóa biểu"+""));
        arrmenu.add(new MenuMain("https://cdn-01.dhcnhn.vn/img/logo-haui-size.png","Tài chính"+""));
        arrmenu.add(new MenuMain("https://cdn-01.dhcnhn.vn/img/logo-haui-size.png","Kết quả học tập"+""));
        arrmenu.add(new MenuMain("https://cdn-01.dhcnhn.vn/img/logo-haui-size.png","Lịch thi"+""));
        arrmenu.add(new MenuMain("https://cdn-01.dhcnhn.vn/img/logo-haui-size.png","Tốt Nghiệp"+""));
        arrmenu.add(new MenuMain("https://cdn-01.dhcnhn.vn/img/logo-haui-size.png","Dịch vụ một cửa"+""));
        arrmenu.add(new MenuMain("https://cdn-01.dhcnhn.vn/img/logo-haui-size.png","Đánh giá"+""));
        arrmenu.add(new MenuMain("https://cdn-01.dhcnhn.vn/img/logo-haui-size.png","Hỏi đáp"+""));
        arrmenu.add(new MenuMain("https://cdn-01.dhcnhn.vn/img/logo-haui-size.png","Ai giá tốt"+""));
        recyclerView_menu = (RecyclerView)findViewById (R.id.recyclerview_main);
        recyclerView_menu.setHasFixedSize(true);
        recyclerView_menu.setLayoutManager(new GridLayoutManager(TrangchuActivity.this,3));
        recyclerView_menu.setAdapter(menuMain);


    }


    public void GetData() {
        Intent intent = getIntent();
        final String masv = intent.getStringExtra("masv");
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlThongtinSv,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                arrSinhvien.add(new SinhVien(
                                        jsonObject.getInt("masv"),
                                        jsonObject.getString("tensv"),
                                        jsonObject.getString("anhsv"),
                                        jsonObject.getString("lopsv"),
                                        jsonObject.getString("khoasv"),
                                        jsonObject.getString("sodutaikhoansv")));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        sinhVienAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<>();
                param.put("masv", masv);
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }
}
