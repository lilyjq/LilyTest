package com.example.lily.lilytest.metrial_design.toolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.lily.lilytest.R;

import java.util.ArrayList;

/**
 * Created by ljq
 * on 2017/12/23.
 */

public class ToolBarActivity extends AppCompatActivity{
    Toolbar toolbar;
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//一定要写这个啊 还设置activity 为无ActionBar的style 如果你要设置toolbar.setNavigationIcon(); 一定要在这句话之后
         toolbar.setOverflowIcon(getResources().getDrawable(R.mipmap.abc_ic_menu_moreoverflow_mtrl_alpha));

        //给TOOLBAR添加menu 的方法 1
        // toolbar.inflateMenu(R.menu.my_menu);

     /*   toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });*/
        //  setSupportActionBar(toolbar);
        recyclerView= (RecyclerView) findViewById(R.id.recycler);
        initView();
    }

    //用setSupportActionBar后重写下面两个方法可以添加menu和menu的点击事件
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void initView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<44;i++){
            list.add("I WILL WIN!"+i);
        }
        recyclerView.setAdapter(new TestAdapter(this,list));



    }
}
