package com.example.lily.lilytest;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.lily.lilytest.home.BottomNavigationActivity;
import com.example.lily.lilytest.metrial_design.Metrial_Design_Activity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {



    private TextView tv_md;
    private TextView tv_retrofit;
    private Button bt_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        tv_md= (TextView) findViewById(R.id.m_dsign);
        tv_md.setOnClickListener(this);
        tv_retrofit= (TextView) findViewById(R.id.tv_retofit);
        tv_retrofit.setOnClickListener(this);
        bt_home= (Button) findViewById(R.id.button);
        bt_home.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.m_dsign){
            Intent intent=new Intent(this, Metrial_Design_Activity.class);
            startActivity(intent);
        }
        if(v.getId()==R.id.tv_retofit){
          //  Intent intent=new Intent(this, TestRetroft.class);
         //   startActivity(intent);
        }
        if(v.getId()==R.id.button){
            Intent intent=new Intent(this, BottomNavigationActivity.class);
            startActivity(intent);
        }
    }
}
