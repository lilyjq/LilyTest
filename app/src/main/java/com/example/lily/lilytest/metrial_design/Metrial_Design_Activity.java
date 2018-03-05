package com.example.lily.lilytest.metrial_design;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.lily.lilytest.R;
import com.example.lily.lilytest.metrial_design.appbarlayout.AppBarActivity;
import com.example.lily.lilytest.metrial_design.appbarlayout.CollapsingToolBarActivity;
import com.example.lily.lilytest.metrial_design.toolbar.SideMenuActivity;
import com.example.lily.lilytest.metrial_design.toolbar.ToolBarActivity;

/**
 * Created by ljq
 * on 2017/12/23.
 */

public class Metrial_Design_Activity extends Activity implements View.OnClickListener {


   private TextView tv_toolbar;
    private TextView tv_appbarlayout;
    private TextView tv_collapsing,tv_sidemenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metrialdesign);
        tv_toolbar= (TextView) findViewById(R.id.tv_toolbar);
        tv_toolbar.setOnClickListener(this);
        tv_appbarlayout= (TextView) findViewById(R.id.tv_appbarlayout);
        tv_appbarlayout.setOnClickListener(this);
        tv_collapsing= (TextView) findViewById(R.id.tv_collapsinglayout);
        tv_collapsing.setOnClickListener(this);
        tv_sidemenu= (TextView) findViewById(R.id.tv_sidemenu);
        tv_sidemenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.tv_toolbar){
            Intent intent=new Intent(this, ToolBarActivity.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.tv_appbarlayout){
            Intent intent=new Intent(this, AppBarActivity.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.tv_collapsinglayout){
            Intent intent=new Intent(this, CollapsingToolBarActivity.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.tv_sidemenu){
            Intent intent=new Intent(this, SideMenuActivity.class);
            startActivity(intent);
        }
    }
}
