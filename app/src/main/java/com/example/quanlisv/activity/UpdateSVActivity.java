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
import com.example.quanlisv.model.DanhSachSV;

import java.util.HashMap;
import java.util.Map;

import static com.example.quanlisv.utility.Server.urlUpdatesv;

public class UpdateSVActivity extends AppCompatActivity {
    EditText  edt_uptensv, edt_uplopsv, edt_upkhoasv, edt_upsodutk, edt_uppass,edt_upanhsv;
    Button btn_capnhat, btn_huyup;
    int masv=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sv);
        InitView();
        Intent intent = getIntent();
        DanhSachSV danhSachSV = (DanhSachSV)intent.getSerializableExtra("datasinhvien");
        edt_uptensv.setText(danhSachSV.getTensv());
        edt_upanhsv.setText(danhSachSV.getAnhsv());
        edt_upkhoasv.setText(danhSachSV.getKhoasv());
        edt_upsodutk.setText(danhSachSV.getSodutaikoan());
        edt_uplopsv.setText(danhSachSV.getLopsv());
        edt_uppass.setText(danhSachSV.getPass()+"");
        masv = danhSachSV.getMasv();
        btn_capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CapnhatSV();
            }
        });
        btn_huyup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void InitView() {
        edt_uptensv = (EditText)findViewById(R.id.edt_uptensv);
        edt_uplopsv = (EditText)findViewById(R.id.edt_uplopsv);
        edt_upkhoasv = (EditText)findViewById(R.id.edt_upkhoasv);
        edt_upsodutk = (EditText)findViewById(R.id.edt_upsodutk);
        edt_uppass = (EditText)findViewById(R.id.edt_uppass);
        edt_upanhsv = (EditText)findViewById(R.id.edt_upanhsv);
        btn_capnhat = (Button) findViewById(R.id.btn_capnhat);
        btn_huyup = (Button)findViewById(R.id.btn_huyup);

    }

    public void CapnhatSV(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.POST, urlUpdatesv,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.contains("1")){
                            Intent intent1 = new Intent(getApplicationContext(), AdminDanhSachSV.class);
                            intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent1);
                            Toast.makeText(getApplicationContext(),"Cập nhật thành công",Toast.LENGTH_LONG).show();
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
                params.put("masv",Integer.toString(masv));
                params.put("tensv",edt_uptensv.getText().toString());
                params.put("lopsv",edt_uplopsv.getText().toString());
                params.put("anhsv",edt_upanhsv.getText().toString().trim());
                params.put("khoasv",edt_upkhoasv.getText().toString());
                params.put("sodutaikhoansv",edt_upsodutk.getText().toString());
                params.put("pass",edt_uppass.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(request);
    }
}
