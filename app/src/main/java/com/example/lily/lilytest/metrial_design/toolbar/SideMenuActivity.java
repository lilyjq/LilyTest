package com.example.lily.lilytest.metrial_design.toolbar;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lily.lilytest.R;

import java.util.ArrayList;

/**
 * Created by ljq
 * on 2018/2/28.
 */

public class SideMenuActivity extends AppCompatActivity implements View.OnClickListener {


    Toolbar toolbar;
    ListView  leftMenu;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidemenu);

        toolbar= (Toolbar) findViewById(R.id.side_toolbar);
        setSupportActionBar(toolbar);

       drawerLayout= (DrawerLayout) findViewById(R.id.drawerlayout);
        recyclerView= (RecyclerView) findViewById(R.id.side_menue_list);

        toolbar.setNavigationOnClickListener(this);
        toolbar.setOverflowIcon(getResources().getDrawable(R.mipmap.abc_ic_menu_moreoverflow_mtrl_alpha));
        initView();

        //这个是可以检测侧拉菜单的的开启和关闭
        /*drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.str_toolbar,R.string.app_name){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Toast.makeText(getBaseContext(),"drawer Open",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Toast.makeText(getBaseContext(),"drawer Close",Toast.LENGTH_SHORT).show();
            }
        };*/

      //  drawerLayout.setDrawerListener(drawerToggle); //已过时
      // drawerLayout.addDrawerListener(drawerToggle);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

//setNavigationOnClickListener
    @Override
    public void onClick(View v) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }else{
            drawerLayout.openDrawer(GravityCompat.START);
        }


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
