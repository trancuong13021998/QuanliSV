package com.example.quanlisv.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

import static com.example.quanlisv.utility.Server.urlLogin;

public class MainActivity extends AppCompatActivity {
        EditText edtPass,edtUser;
        Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= edtUser.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                if (user.isEmpty()||pass.isEmpty()){
                    edtPass.setError("Nhập mật khẩu");
                    edtUser.setError("Nhập mã sinh viên");
                }
                else {
                    Login(user,pass);
                }
            }
        });
    }
    private void InitView() {
        edtPass= (EditText)findViewById(R.id.edtPassword);
        edtUser =(EditText)findViewById(R.id.edtUsername);
        btnLogin = (Button)findViewById(R.id.btn_login);
    }
    public void Login(final String user, final String pass){
        StringRequest request = new StringRequest(Request.Method.POST, urlLogin,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.contains("1")){
                            Intent intent= new Intent(MainActivity.this, TrangchuActivity.class);
                            intent.putExtra("masv",user);
                            startActivity(intent);
                            //onDestroy();
                        }
                        else if (response.contains("2")){
                            Intent intent= new Intent(MainActivity.this, ChuongTrinhDaoTaoActivity.class);
                            intent.putExtra("masv",user);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Kiểm tra lại mã sinh viên hoặc mật khẩu",Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param = new HashMap<>();
                param.put("masv",user);
                param.put("pass",pass);
                return param;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
