package com.example.didongdn.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
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
import com.example.didongdn.model.Topic;

import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {

    ListView lvTopic;
    ArrayList<Topic> topicArrayList;
    TopicAdapter topicAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lvTopic = findViewById(R.id.LvTopic);
        topicArrayList = new ArrayList<>();

        GetData();

    }
    private void GetData()
    {

        DataService dataService = ApiService.getService();
        Call<List<Topic>> callback = dataService.GetDataTopic();
        callback.enqueue(new Callback<List<Topic>>() {
            @Override
            public void onResponse(Call<List<Topic>> call, Response<List<Topic>> response) {
                topicArrayList = (ArrayList<Topic>) response.body();
                //Log.d("aaa",topicArrayList.get(0).getCreatedAt());
                topicAdapter = new TopicAdapter(Main2Activity.this,R.layout.dong_topic,topicArrayList);
                lvTopic.setAdapter(topicAdapter);
                Toast.makeText(Main2Activity.this,topicArrayList.get(0).getCreator().getUsername(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Topic>> call, Throwable t) {

            }
        });

    }
}
