package com.example.quanlisv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.quanlisv.R;

import java.util.HashMap;
import java.util.Map;

import static com.example.quanlisv.utility.Server.urlThemsv;

public class ThemSVActivity extends AppCompatActivity {
    EditText edt_masv, edt_tensv, edt_lopsv, edt_khoasv, edt_sodutk, edt_pass,edt_anhsv;
    Button btn_themsv, btn_huy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sv);
        InitView();
        btn_themsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edt_tensv.getText().toString();
                String masv = edt_masv.getText().toString();
                String anhsv = edt_anhsv.getText().toString();
                String lopsv = edt_lopsv.getText().toString();
                String khoasv = edt_khoasv.getText().toString();
                String taikhoan = edt_sodutk.getText().toString();
                String pass = edt_pass.getText().toString();
            if (ten.isEmpty()||masv.isEmpty()||anhsv.isEmpty()||lopsv.isEmpty()||khoasv.isEmpty()||taikhoan.isEmpty()||pass.isEmpty()){
                edt_pass.setError("Nhập mật khẩu");
                edt_sodutk.setError("Nhập số dư tài khoản");
                edt_anhsv.setError("nhập link ảnh");
                edt_pass.setError("Nhập mật khẩu");
                edt_tensv.setError("Nhập tên sinh viên");
                edt_khoasv.setError("Nhập khoa sinh viên");
                edt_lopsv.setError("Nhập lớp sinh viên");
            }
            else {
                ThemSV();
            }
            }
        });
        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void InitView() {
        edt_masv = (EditText) findViewById(R.id.edt_masv);
        edt_tensv = (EditText) findViewById(R.id.edt_tensv);
        edt_lopsv = (EditText) findViewById(R.id.edt_lopsv);
        edt_khoasv = (EditText) findViewById(R.id.edt_khoasv);
        edt_sodutk = (EditText) findViewById(R.id.edt_sodutk);
        edt_pass = (EditText) findViewById(R.id.edt_pass);
        edt_anhsv = (EditText)findViewById(R.id.edt_anhsv);
        btn_huy = (Button) findViewById(R.id.btn_huy);
        btn_themsv = (Button) findViewById(R.id.btn_themsv);
    }
    public  void ThemSV(){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlThemsv,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("1")){
                            Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), AdminDanhSachSV.class));
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Thêm không thành công",Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("masv",edt_masv.getText().toString().trim());
                params.put("tensv",edt_tensv.getText().toString());
                params.put("anhsv",edt_anhsv.getText().toString().trim());
                params.put("lopsv",edt_lopsv.getText().toString());
                params.put("khoasv",edt_khoasv.getText().toString());
                params.put("sodutaikhoansv",edt_sodutk.getText().toString().trim());
                params.put("pass",edt_pass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}
