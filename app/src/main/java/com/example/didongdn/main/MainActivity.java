package com.example.didongdn.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.didongdn.R;
import com.example.didongdn.adapter.TopicAdapter;
import com.example.didongdn.api.ApiService;
import com.example.didongdn.api.DataService;
import com.example.didongdn.model.Nguoidung;
import com.example.didongdn.model.Topic;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Nguoidung> nguoidungArrayList;
    Button DangNhap;
    Button DangKy;
    EditText email;
    EditText Pass;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DangNhap = findViewById(R.id.btnDN);
        DangKy = findViewById(R.id.btnDK);
        email = findViewById(R.id.txtTaiKhoan);
        Pass = findViewById(R.id.txtPass);
       // nguoidungArrayList = new ArrayList<>();
      // getData();
        xuLyDN();
    }


    public void xuLyDN()
    {

        DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataService dataService = ApiService.getService();
                Call<List<Nguoidung>> callback = dataService.LoginData(email.getText().toString(),Pass.getText().toString());
                callback.enqueue(new Callback<List<Nguoidung>>() {
                    @Override
                    public void onResponse(Call<List<Nguoidung>> call, Response<List<Nguoidung>> response) {
                        nguoidungArrayList = (ArrayList<Nguoidung>) response.body();
                         //Log.d("BBB",response.body().toString());
                        Toast.makeText(MainActivity.this, response.body().get(0).getUsername(), Toast.LENGTH_SHORT).show();
//                if (nguoidungArrayList.size() > 0)
//                {
//                    Toast.makeText(MainActivity.this, "Không có tài khoản này", Toast.LENGTH_SHORT).show();
//                    //Log.d("BBB",nguoidungArrayList.get(0).getPasswordDigest());
//                }else
//                        {
//                            Toast.makeText(MainActivity.this, "Không có tài khoản này", Toast.LENGTH_SHORT).show();
//                        }
//                        //Toast.makeText(MainActivity.this,nguoidungArrayList.get(0).getPasswordDigest(),Toast.LENGTH_SHORT).show();
//                        // xuLyDN();


                    }

                    @Override
                    public void onFailure(Call<List<Nguoidung>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();

                    }
                });





            }
        });
    }
}
