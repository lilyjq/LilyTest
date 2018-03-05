package com.example.lily.lilytest.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


import com.example.lily.lilytest.R;

/**
 * Created by ljq
 * on 2018/3/1.
 */

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    MenuItem menuItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.design_navigation_view);
        initData();
        initNavigation();
    }


    private void initNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        BottomShiftHelper.disableShiftMode(bottomNavigationView);


    }

    ViewPagerAdapter adapter;
    private void initData(){
        adapter =new ViewPagerAdapter(getSupportFragmentManager());

        for(int i=0;i<5;i++){
            adapter.adddate(ViewPagerFragment.newInstance("页面"+i));
        }
        viewPager.setAdapter(adapter);
       // adapter.notifyDataSetChanged();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(menuItem!=null){
                    menuItem.setChecked(false);
                }else{
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem=bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                viewPager.setCurrentItem(0);
                break;
            case R.id.center:
                viewPager.setCurrentItem(1);
                break;
            case R.id.message:
                viewPager.setCurrentItem(2);
                break;
            case R.id.mine:
                viewPager.setCurrentItem(3);
                break;
            case R.id.tushu:
                viewPager.setCurrentItem(4);
                break;
                default:
                    break;

        }
        return false;
    }
}
