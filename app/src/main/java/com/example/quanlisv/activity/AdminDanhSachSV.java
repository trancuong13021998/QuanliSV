package com.example.quanlisv.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.quanlisv.R;
import com.example.quanlisv.adapter.DanhSachSVAdapter;
import com.example.quanlisv.model.DanhSachSV;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.quanlisv.utility.Server.urlDanhsachSv;
import static com.example.quanlisv.utility.Server.urlDeletesv;

public class AdminDanhSachSV extends AppCompatActivity {
    RecyclerView rcl_dsachsv;
    ArrayList<DanhSachSV> listdanhSachSVA;
    DanhSachSVAdapter danhSachSVAdapter;
    androidx.appcompat.widget.Toolbar toolbarDSachSv;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_danh_sach_sv);
        InitView();
        GetData();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void InitView(){
        toolbarDSachSv= (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar_DSSV);
        setSupportActionBar(toolbarDSachSv);
        ActionBar actionBar = getSupportActionBar();
        rcl_dsachsv = (RecyclerView)findViewById(R.id.rcl_dsachsv);
        listdanhSachSVA = new ArrayList<>();
        danhSachSVAdapter= new DanhSachSVAdapter(AdminDanhSachSV.this,listdanhSachSVA);
        rcl_dsachsv.setHasFixedSize(true);
        rcl_dsachsv.setLayoutManager(new LinearLayoutManager(this));
        rcl_dsachsv.setAdapter(danhSachSVAdapter);
    }
    public void GetData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, urlDanhsachSv,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            listdanhSachSVA.clear();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                listdanhSachSVA.add(new DanhSachSV(
                                        jsonObject.getInt("masv"),
                                        jsonObject.getString("tensv"),
                                        jsonObject.getString("anhsv"),
                                        jsonObject.getString("lopsv"),
                                        jsonObject.getString("khoasv"),
                                        jsonObject.getString("sodutaikhoansv"),
                                        jsonObject.getInt("pass")));
                            }
                            danhSachSVAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();

            }
        }) ;
        requestQueue.add(stringRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_them,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id== R.id.them){
            Intent intent = new Intent(getApplicationContext(), ThemSVActivity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
    public void XoaSv(final int masv){
        final RequestQueue requestQueue1 = Volley.newRequestQueue(this);
        StringRequest request1 = new StringRequest(Request.Method.POST, urlDeletesv,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("1")){
                            Toast.makeText(getApplicationContext(),"Xóa thành công",Toast.LENGTH_LONG).show();
                            GetData();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Lỗi",Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("masv",Integer.toString(masv));
                return params;
            }
        };
        requestQueue1.add(request1);
    }
}
