package com.lx.gridviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private MyAdapter adapter;
    private List<User> user;
    private int id[] = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,
            R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,
            R.drawable.n,R.drawable.o,R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,
            R.drawable.u,R.drawable.v,R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        for (int i = 0;i<id.length;i++){
            user.add(new User(id[i],"王尼玛"+i+"号"));
        }
        adapter = new MyAdapter(this,user);
        gridView.setAdapter(adapter);
    }

    private void initView() {
        gridView = (GridView) findViewById(R.id.gridView);
        user = new ArrayList<>();
    }
}
