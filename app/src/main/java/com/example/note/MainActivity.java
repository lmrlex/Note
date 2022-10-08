package com.example.note;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import Adapter.MainRecyclerviewAdapter;
import pojo.MainContent;

public class MainActivity extends AppCompatActivity {
    public SmartRefreshLayout refreshLayout;
    private Toolbar toolbar;
    private RecyclerView mainRecyclerView;
    private MainRecyclerviewAdapter mainRecyclerviewAdapter;
    List<MainContent> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initRecyclerView();
        mainRecyclerView=findViewById(R.id.main_recyclerview);
        mainRecyclerviewAdapter=new MainRecyclerviewAdapter(list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        mainRecyclerView.setLayoutManager(linearLayoutManager);
        mainRecyclerView.setAdapter(mainRecyclerviewAdapter);
        refreshLayout=findViewById(R.id.refresh);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mainRecyclerviewAdapter.notifyDataSetChanged();

                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {

                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }

    private void initRecyclerView() {
        list.add(new MainContent("仅是天气真好","2021-02-03"));
        list.add(new MainContent("仅是天气真好","2021-02-03"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.sousuo:
                Toast.makeText(this, "待更新", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bianji:
                Toast.makeText(this, "待更新1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.shezhi:
                Toast.makeText(this, "待更新2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sort:
                Toast.makeText(this, "待更新3", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}